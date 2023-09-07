package kodlamaio.hmrs.entities.concrete;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position")
    @NotNull
    private String position;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "available_position")
    @NotNull
    private int availablePosition;

    @Column(name = "deadline")
    @NotNull
    private Timestamp deadline;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
