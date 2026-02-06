package com.example.backend_my_web_portafoglio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe di configurazione CORS (Cross-Origin Resource Sharing)
 *
 * Permette al frontend, eseguito su dominio diverso dal backend, di effettuare
 * richieste HTTP verso le API dell'applicazione.
 *
 * In questa configurazione sono consentite le richieste provenienti
 * dal client Angular in esecuzione su {@code http://localhost:4200}
 * verso gli end point {@code /api/**}
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * Configura le regole CORS per le API dell'applicazione
     *
     * @param registry oggetto utilizzato da Spring per registrare le policy CORS
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200", "http://localhost")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
