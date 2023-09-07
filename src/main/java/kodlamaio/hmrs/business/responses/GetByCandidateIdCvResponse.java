package kodlamaio.hmrs.business.responses;

import java.util.List;

import kodlamaio.hmrs.business.requestes.candidateschool.EducationInformationResponse;
import kodlamaio.hmrs.business.responses.candidateforeignlanguage.GetByCandidateForeignLanguageResponse;
import kodlamaio.hmrs.business.responses.candidatejobexperience.GetByCandidateIdJobExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateIdCvResponse {
    private String firstName;
    private String lastName;
    private String githubUrl;
    private String linkedinUrl;
    private String coverLetter;
    private List<EducationInformationResponse> educationInformations;
    private List<GetByCandidateIdJobExperience> experiences;
    private List<GetByCandidateForeignLanguageResponse> languageResponses;
}
