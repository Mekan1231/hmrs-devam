package kodlamaio.hmrs.business.requestes.employer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateEmployerRequest {

    @NotNull(message = "Bir değer girilmek zorunda")
    @NotBlank(message = "Boş geçilemez")
    private String username;
    
    @NotNull
    @NotBlank
    private String companyName;

    @NotNull
    @NotBlank
    private String webSite;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String password;

    @NotBlank
    @NotNull
    private String confirmedPassword;

}
