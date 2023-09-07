package kodlamaio.hmrs.webApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.business.responses.GetByCandidateIdCvResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/cv")
public class CvsController {
    private CvService cvService;

    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getByCandidateId")
    public DataResult<GetByCandidateIdCvResponse> getByCandidateIdCv(int id){
        return this.cvService.getByCandidateId(id);
    }
}
