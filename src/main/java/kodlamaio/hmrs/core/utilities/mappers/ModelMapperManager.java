package kodlamaio.hmrs.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;



@Service
public class ModelMapperManager implements ModelMapperService {

    
    private ModelMapper mapper;
    private ModelMapperManager() {
        this.mapper= new ModelMapper();
    }


    @Override
    public ModelMapper forResponse() {
        this.mapper.getConfiguration()
        .setAmbiguityIgnored(true)
        .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.mapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.mapper.getConfiguration()
        .setAmbiguityIgnored(true)
        .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.mapper;
    }
    
}
