package br.com.fiap.spring.configuration;

import br.com.fiap.spring.validator.LivroValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public LivroValidator livroValidator(){
        return new LivroValidator();
    }

}
