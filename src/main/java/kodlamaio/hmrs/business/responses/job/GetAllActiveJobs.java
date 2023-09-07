package kodlamaio.hmrs.business.responses.job;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllActiveJobs {
    private String employerCompanyName; 
    private String cityName;
    private String position;
    private int availablePosition;
    private Timestamp deadline;
}
