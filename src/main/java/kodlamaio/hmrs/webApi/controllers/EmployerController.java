package kodlamaio.hmrs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.requestes.employer.CreateEmployerRequest;
import kodlamaio.hmrs.business.responses.employer.GetAllEmployerResponse;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;
    
    @PostMapping("/add")
    public Result add(@RequestBody CreateEmployerRequest employerRequest) {
        return employerService.add(employerRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<GetAllEmployerResponse>> getAll() {
        return employerService.getAll();
    }
}
