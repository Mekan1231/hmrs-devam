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
@Table(name = "candidate_schools")
public class CandidateSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cadidate_cv_id", nullable = false)
    private CandidateCV candidateCV;

    @Column(name = "start_date", nullable = false)
    @NotNull
    private Date startDate;

    @Column(name = "finish_date",nullable = true)
    private Date finishDate;

    @Column(name = "is_currently_enrolled")
    private boolean isCurrentlyEnrolled=false;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @PrePersist
    public void prePersist() {
        if (finishDate==null) {
            isCurrentlyEnrolled=true;
        }
    }
    //@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //private Date createdAt;
}
