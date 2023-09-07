package kodlamaio.hmrs.business.requestes.candidatejobexperience;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateJobExperienceRequest {
    
    @NotNull
    @NotBlank(message = "Bos gecilemez")
    private String companyName;

    @NotNull
    @NotBlank(message = "Bos gecilemez")
    private String position;

    @NotNull
    private Date startDate;
    private Date finishDate;
    
}
