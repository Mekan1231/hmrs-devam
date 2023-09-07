package kodlamaio.hmrs.entities.concrete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import kodlamaio.hmrs.entities.abstracts.User;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Candidates extends User {
  

    @Column(name = "firstname")
    @NotNull
    private String firstname;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "identity_number")
    @NotNull
    private String identityNo;


    @Column(name = "date_of_birth")
    @NotNull
    private String birthDate;

    


   


  
}
