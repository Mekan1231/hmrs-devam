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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Employer extends User {
    @Column(name = "domain_name")
    @NotNull
    private String website;

    @Column(name = "company_name")
    private String companyName;

  
}
