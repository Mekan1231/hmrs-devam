package kodlamaio.hmrs.business.responses.candidatejobexperience;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateIdJobExperienceTemp {
    private String companyName;
    private String position;
    private Date startDate;
    private Date finishDate;
}
