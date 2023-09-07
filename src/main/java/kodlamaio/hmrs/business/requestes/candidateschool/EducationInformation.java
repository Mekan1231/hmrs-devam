package kodlamaio.hmrs.business.requestes.candidateschool;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformation {
    private String schoolName;
    private String departmentName;
    private Date finishDate;

    

}
