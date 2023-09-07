package kodlamaio.hmrs.business.responses.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerResponse {
    private int id;
    private String username;
    private String companyName;
    private String webSite;
    private String password;
    private String email;
}
