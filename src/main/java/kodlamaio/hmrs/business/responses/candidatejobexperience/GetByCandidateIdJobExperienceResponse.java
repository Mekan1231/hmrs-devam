package kodlamaio.hmrs.business.responses.candidatejobexperience;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateIdJobExperienceResponse {
    private String firstName;
    private String secondName;
    private List<GetByCandidateIdJobExperience> experiences;
}
