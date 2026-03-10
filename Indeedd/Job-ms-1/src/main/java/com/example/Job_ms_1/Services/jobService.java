package com.example.Job_ms_1.Services;

import com.example.Job_ms_1.Dtos.jobCreateDto;
import com.example.Job_ms_1.Entities.Jobs;
import com.example.Job_ms_1.Repositories.jobsRepo;
import com.example.Job_ms_1.cleints.CompanyClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class jobService {
    private final jobsRepo repo;
    private final CompanyClient companyClient;

    @Transactional
    @Retry(name = "companyBreaker",fallbackMethod = "createJobBreaker")
    public Jobs createJob(jobCreateDto dto) {
        log.info("Attempting to create job for company id: {}", dto != null ? dto.getComponyId() : "null");
        if(dto==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Body Received");
        if(dto.getRole()==null || dto.getRole().isBlank()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Role Received");
        if(dto.getOpenings()==null || dto.getOpenings()<=0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Opening Must be greater then 0");
        if(dto.getApplicationStartDate()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No StartDate Received");
        if(dto.getApplicationEndDate()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No EndDate Received");
        if(dto.getApplicationEndDate().isBefore(dto.getApplicationStartDate())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"End Date must be > start date");

            companyClient.getCompany(dto.getComponyId());



                 try {

            return repo.save(
                    Jobs.builder()
                            .role(dto.getRole())
                            .applicationEndDate(dto.getApplicationEndDate())
                            .applicationStartDate(dto.getApplicationStartDate())
                            .description(dto.getDescription())
                            .openings(dto.getOpenings())
                            .componyId(dto.getComponyId())
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @Transactional(readOnly = true)
    public List<Jobs> getAllJobs() {
        return repo.findAll();
    }
    @Transactional(readOnly = true)
    public Jobs getJobDetail(Long id) {
        System.out.println("request recievd for getJobDetail : "+id);
        if(id==null) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id must be given");
        System.out.println("request proceed for getJobDetail : "+id);
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Job With this Id Does not Exist"));
    }

    @Transactional
    public boolean deleteJob(Long id) {
        if(id==null) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id must be given");
        try{
            int rowsDeleted = repo.deleteJobByIdDirectly(id);
            if (rowsDeleted == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found with ID: " + id);
            }
            return true;
        }
        catch (ResponseStatusException e){
            throw e;
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error while deleting job");

    }

}

    @CircuitBreaker(name = "companyBreaker",fallbackMethod = "coompanyBreakerNote")
    public List<Jobs> getAllJobsOfACompany(Long id) {
        System.out.println("jobs company request recived for id :"+id);
        companyClient.getCompany(id);
        try{
            System.out.println("jobs company request recived for id :"+id+", proceed to finding");
            return repo.findByComponyId(id);
        } catch (Exception e) {
            throw new RuntimeException("Something Went Wrong");
        }

    }
    public List<Jobs> coompanyBreakerNote(Long id,Throwable e){
     throw  new ResponseStatusException( HttpStatus.SERVICE_UNAVAILABLE,
             "Company Service is currently unavailable. Please try again later.");
    }

    public int deleteJobofACompany(Long id) {
        if(id==null) throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"Id must be given");
        try{
            return repo.deleteJobByCompanyId(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error while deleting job");

        }
    }
    public Jobs createJobBreaker(jobCreateDto dto, Throwable ex){
        if (ex instanceof FeignException && ((FeignException) ex).status() == 404) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with the provided ID.");
        }
        throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Company Service is currently unavailable. Please try again later."
        );
    }
}