package kodlamaio.hmrs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CandidateCVService;
import kodlamaio.hmrs.business.requestes.candidatecv.CreateCandidateCvRequest;
import kodlamaio.hmrs.core.services.FileUploadService;
import kodlamaio.hmrs.core.utilities.results.Result;

@RestController
@RequestMapping("/candidatecv")
public class CandidateCVController {
    private CandidateCVService cvService;
    private FileUploadService fileUploadService;

    @Autowired
    public CandidateCVController(CandidateCVService cvService, FileUploadService fileUploadService) {
        this.cvService = cvService;
        this.fileUploadService=fileUploadService;
    }

    @PostMapping("/add")
    public Result add( CreateCandidateCvRequest cvRequest){
        return this.cvService.add(cvRequest);
    }

    @PostMapping("/resimEkle")
    public String ekle( MultipartFile file){
        try {
            return this.fileUploadService.uploadFile(file);
            
        } catch (Exception e) {
          return e.getMessage();
        }
    }
}
