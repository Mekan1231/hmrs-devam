package kodlamaio.hmrs.business.responses.candidateforeignlanguage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateForeignLanguageResponse {
    private String name;
    private String level;
}
