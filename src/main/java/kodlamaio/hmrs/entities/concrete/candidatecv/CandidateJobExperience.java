package kodlamaio.hmrs.entities.concrete.candidatecv;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_job_experiences")
public class CandidateJobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "candidate_cv_id", nullable = false)
    private CandidateCV candidateCV;

    @Column(name = "company_name")
    @NotNull
    private String companyName;

    @Column(name = "position")
    @NotNull
    private String position;

    @Column(name = "start_date")
    @NotNull
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @Column(name = "is_currently_working")
    private boolean isCurrentlyWorking=false;


    @PrePersist
    public void prePersist() {
        if (finishDate==null) {
            isCurrentlyWorking=true;
        }
    }

    //@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //private Date createdAt;
}
