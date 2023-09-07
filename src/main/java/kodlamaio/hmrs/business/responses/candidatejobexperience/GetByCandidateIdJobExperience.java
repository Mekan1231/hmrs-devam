package kodlamaio.hmrs.business.responses.candidatejobexperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateIdJobExperience {
    private String companyName;
    private String position;
    private String startDate;
    private String finishDate;
}
