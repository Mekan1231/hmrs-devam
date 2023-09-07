package kodlamaio.hmrs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateForeignLanguageService;
import kodlamaio.hmrs.business.requestes.candidateforeignlanguage.CreateCandidateForeiegnLanguageRequest;
import kodlamaio.hmrs.business.responses.candidateforeignlanguage.GetByCandidateForeignLanguageResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidateforeignlanguage")
public class CandidateForeignLanguagesController {
    private CandidateForeignLanguageService foreignLanguageService;

    @Autowired
    public CandidateForeignLanguagesController(CandidateForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @PostMapping("/add")
    public Result add( CreateCandidateForeiegnLanguageRequest request){
        return this.foreignLanguageService.add(request);
    }

    @GetMapping("/getbycandidateid")
    public DataResult<List<GetByCandidateForeignLanguageResponse>> getByCandidateId( int id){
        return this.foreignLanguageService.getByCandidateId(id);
    }
}
