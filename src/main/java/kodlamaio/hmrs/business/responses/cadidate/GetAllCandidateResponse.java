package kodlamaio.hmrs.business.responses.cadidate;

import java.util.Date;

import lombok.Data;

@Data
public class GetAllCandidateResponse {
    private String firstName;
    private String lastName;
    private String identityNo;
    private Date birthDate;
    private String email;
    private String password;
}
