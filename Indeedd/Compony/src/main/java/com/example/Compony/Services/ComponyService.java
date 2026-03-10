package com.example.Compony.Services;

import com.example.Compony.Clients.JobClient;
import com.example.Compony.Clients.ReviewClient;
import com.example.Compony.Dtos.ComponyCreateDto;
import com.example.Compony.Dtos.GetCompanyWithReviewDto;
import com.example.Compony.Entities.Compony;
import com.example.Compony.External.Review;
import com.example.Compony.Repositories.ComponyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComponyService {
    private  final ComponyRepo repo;
    private final ReviewClient reviewClient;
    private  final JobClient jobClients;
    @Transactional(readOnly = true)
    public List<Compony> getAllCompony(){
        return repo.findAll();
    }

    @Transactional
    public Compony createCompony(ComponyCreateDto dto) {
        if(dto==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Request Body is Missing");
        try{
            Compony compony = Compony.builder()
                    .name(dto.getName())
                    .employees(dto.getEmployees())
                    .location(dto.getLocation())
                    .build();
            return repo.save(compony);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error while creating Company");
        }

    }


    public boolean deleteCompony(Long id){

        if(repo.existsById(id)){
            repo.deleteById(id);
            try {
                jobClients.deleteAllJobsofACompany(id);
                reviewClient.deleteReviewsOfACompany(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }

    public Compony getById(Long id) {
        return repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Compony not found with id: "+id));

    }
}
