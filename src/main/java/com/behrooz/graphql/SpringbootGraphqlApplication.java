package com.behrooz.graphql;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.Objects;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class SpringbootGraphqlApplication {
    private final Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootGraphqlApplication.class, args);
    }

    @SneakyThrows
    @PostConstruct
    private void postConstruct() {
        String protocol = "https";
        if (Objects.isNull(environment.getProperty("server.ssl.key-store"))) {
            protocol = "http";
        }
        String port = environment.containsProperty("server.port")? environment.getProperty("server.port") : "8080";
        String appName = environment.containsProperty("spring.application.name")? environment.getProperty("spring.application.name") : getClass().getSimpleName();
        String url = protocol.concat("://localhost:").concat(port);

        log.info("\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Graphql console : \t{}/graphiql\n\t"
                        + "H2 console : \t\t{}/h2-console\n\t"
                        + "External: \t\t\t{}://{}:{}\n\t"
                        + "Profile(s): \t\t{}\n----------------------------------------------------------",
                appName,
                url,
                url,
                protocol, InetAddress.getLocalHost().getHostAddress(), port,
                environment.getActiveProfiles());

        /*if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(new String[]{"bash", "-c", "google-chrome ".concat(url)});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
