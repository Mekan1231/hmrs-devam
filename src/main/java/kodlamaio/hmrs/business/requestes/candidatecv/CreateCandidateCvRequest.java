package kodlamaio.hmrs.business.requestes.candidatecv;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateCvRequest {
    @NotNull
    @NotBlank
    private int candidateId;

    private String githubUrl;
    private String linkedinUrl;
    private String coverLetter;






}
