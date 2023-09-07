package kodlamaio.hmrs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CandidateCVImageService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("api/candidatecvimage")
public class CandiateCVImagesController {
    private CandidateCVImageService cvImageService;
    
    @Autowired
    public CandiateCVImagesController(CandidateCVImageService cvImageService) {
        this.cvImageService = cvImageService;
    }

    @PostMapping("add")
    public Result add(@RequestParam int candidateCVId, MultipartFile multipartFile){
        try {
            return this.cvImageService.add(candidateCVId, multipartFile);
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }

    
}
