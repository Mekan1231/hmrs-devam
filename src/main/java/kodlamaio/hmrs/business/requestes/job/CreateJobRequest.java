package kodlamaio.hmrs.business.requestes.job;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobRequest {
    @NotBlank(message = "boş geçilemez")
    @NotNull
    private String position;

    @NotBlank(message = "boş geçilemez")
    @NotNull
    private String jobDescription;

    

    @NotNull(message = "Boş geçilemez")
    private int minSalary;

    @NotNull(message = "Boş geçilemez")
    private int maxSalary;

    @NotNull(message = "Boş geçilemez")
    private int availablePosition;

    @NotNull(message = "Boş geçilemez")
    private Timestamp deadline;

    @NotNull(message = "Boş geçilemez")
    private int userId;

    @NotNull(message = "Boş geçilemez")
    private int typeId;

    @NotNull(message = "Boş geçilemez")
    private int cityId;
}
