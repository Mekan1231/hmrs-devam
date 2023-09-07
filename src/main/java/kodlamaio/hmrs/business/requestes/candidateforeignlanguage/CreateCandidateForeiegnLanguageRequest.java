package kodlamaio.hmrs.business.requestes.candidateforeignlanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateForeiegnLanguageRequest {
    private int cvId;
    private String language;
    private String level;
}
