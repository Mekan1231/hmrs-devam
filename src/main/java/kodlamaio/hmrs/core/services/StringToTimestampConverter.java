package kodlamaio.hmrs.core.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class StringToTimestampConverter implements Converter<String, Timestamp>{

    @Override
    @Nullable
    public Timestamp convert(String source) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            Date presedDate =dateFormat.parse(source);
            return new Timestamp(presedDate.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    
}
