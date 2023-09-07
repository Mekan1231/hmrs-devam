package kodlamaio.hmrs.business.requestes.candidateschool;

import java.sql.Date;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateSchoolRequest {

     
    private int CandidateCVId;

    @NotNull(message = "Bos gecilemez")
    @NotBlank
    private Date StartDate;

    
    private Date FinishDate;

  
    private int schoolId;


    private int departmentId;

    
}

