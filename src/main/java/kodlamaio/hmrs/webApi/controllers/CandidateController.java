package kodlamaio.hmrs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CandidateService;
import kodlamaio.hmrs.business.requestes.candidate.CreateCandidateRequest;
import kodlamaio.hmrs.business.responses.cadidate.GetAllCandidateResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.dataAccess.abstracts.UserRepository;
import kodlamaio.hmrs.entities.abstracts.User;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/candidate")
@AllArgsConstructor
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private UserRepository repository;

    @PostMapping("/add")
    public Result add(@RequestBody CreateCandidateRequest request) {
        return candidateService.add(request);
    }

    @GetMapping("/getall")
    public DataResult<List<GetAllCandidateResponse>> getAll() {
        return candidateService.getAll();
    }

    @GetMapping("/getuser")
    public User get() {
        return repository.findTopByOrderByIdDesc();
    }
}
