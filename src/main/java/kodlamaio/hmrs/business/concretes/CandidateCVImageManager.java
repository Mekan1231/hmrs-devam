package kodlamaio.hmrs.business.concretes;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.business.abstracts.CandidateCVImageService;
import kodlamaio.hmrs.core.services.FileUploadService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVImageRepository;
import kodlamaio.hmrs.dataAccess.abstracts.CandidateCVRepository;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCV;
import kodlamaio.hmrs.entities.concrete.candidatecv.CandidateCVImage;

@Service
public class CandidateCVImageManager implements CandidateCVImageService {

    private CandidateCVImageRepository cvImageRepository; 
    private FileUploadService uploadService;
    private CandidateCVRepository cvRepository;
    
    @Autowired
    public CandidateCVImageManager(
        CandidateCVRepository cvRepository,
        CandidateCVImageRepository cvImageRepository,
        FileUploadService uploadService) {
        this.cvImageRepository = cvImageRepository;
        this.cvRepository=cvRepository;
        this.uploadService=uploadService;
    }
    @Override
    public Result add(int candidateCVId, MultipartFile multipartFile) throws IOException {
        try {
           
            CandidateCVImage cvImage = new CandidateCVImage();
            cvImage.setImageUrl(this.uploadService.uploadFile(multipartFile));
            CandidateCV candidateCV = cvRepository.findById(candidateCVId).get();
            cvImage.setCandidateCV(candidateCV);
            this.cvImageRepository.save(cvImage);
            return new SuccessResult("Ekleme başarılı");
        } catch (Exception e) {
            return new ErrorResult(e.getMessage());
        }
    }
    
}
