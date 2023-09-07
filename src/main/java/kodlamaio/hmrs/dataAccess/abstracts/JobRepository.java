package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hmrs.entities.concrete.Job;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
    List<Job> getByIsActive(boolean state);
    List<Job> getByIsActiveOrderByDeadlineAsc(boolean state);
    List<Job> getByEmployerCompanyNameAndIsActive(String companyName, boolean state);
}
