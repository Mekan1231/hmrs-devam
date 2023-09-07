package kodlamaio.hmrs.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hmrs.core.utilities.results.Result;

public interface CandidateCVImageService {
    Result add(int candidateCVId, MultipartFile multipartFile)throws IOException;
}
