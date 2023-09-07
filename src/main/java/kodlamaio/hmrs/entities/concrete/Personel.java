package kodlamaio.hmrs.entities.concrete;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import kodlamaio.hmrs.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "personnels")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@AllArgsConstructor
public class Personel extends User {

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
    private Date birthDate;

    @Column(name = "salary")
    private String salary;

}
