package kodlamaio.hmrs.business.requestes.candidateschool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationResponse {
    private String schoolName;
    private String departmentName;
    private String finishDate;
}
