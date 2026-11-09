package edu.neumont.csc280.witcher.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS: lets the UI, served from a DIFFERENT origin (http://localhost:8081), call this API
 * (http://localhost:8080). Browsers block that by default; the API has to say "this
 * origin is allowed". Postman doesn't care about CORS, only browsers do.
 *
 * The one-controller alternative is @CrossOrigin("http://localhost:8081") on the class.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
            .allowedOrigins("http://localhost:8081")         // the UI's address, exactly
            .allowedMethods("GET", "POST", "PUT", "DELETE"); // what the page uses
    }
}
