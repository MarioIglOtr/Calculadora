package com.sanitas.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${api.scheme}")
    private String SCHEME;

    @Value("${api.host}")
    private String HOST;

    @Value("${api.port}")
    private String PORT;

    @Bean
    public OpenAPI myOpenAPI() {
        final Server devServer = new Server();
        devServer.setUrl(SCHEME + "://" + HOST + ":"+ PORT);
        devServer.setDescription("Server URL in Development environment");

        final Info info = new Info()
                .title("Calculadora API")
                .version("1.0");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
