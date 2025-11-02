package com.example.revision_4.SecurityStuff;

import com.example.revision_4.Entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
@Component
@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final UserRepo userRepo;
    private final AuthUtil authUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

  try {

      log.info("Incoming requestes=> {}", request.getRequestURI());

      final String requestTokenHeader = request.getHeader("Authorization");
      if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
          filterChain.doFilter(request, response);
          return;
      }
      String token = requestTokenHeader.split("Bearer ")[1];
      String username = authUtil.extractUsername(token);

      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
          User user = userRepo.findByUsername(username).orElseThrow();
          UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(upat);

      }
      filterChain.doFilter(request, response);

  }
  catch (Exception ex){
handlerExceptionResolver.resolveException(request,response,null,ex);
  }




    }
}
