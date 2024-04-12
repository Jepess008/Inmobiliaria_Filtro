package campuslands.Inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
