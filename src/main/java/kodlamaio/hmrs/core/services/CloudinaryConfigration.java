package kodlamaio.hmrs.core.services;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfigration {
    private final String CLOUD_NAME = "dzsfdt38l";
    private final String API_KEY = "744639852413753";
    private final String API_SECRET = "g4BlCTXCBMNChEHhYp0bnFs333k";
    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name",CLOUD_NAME);
        config.put("api_key",API_KEY);
        config.put("api_secret",API_SECRET);

        return new Cloudinary(config);
    }
}
