package kodlamaio.hmrs.business.requestes.candidateschool;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCandidateIdResponse {
    private String name;
    private String surename;
    private List<EducationInformationResponse> educationInformations;
}
