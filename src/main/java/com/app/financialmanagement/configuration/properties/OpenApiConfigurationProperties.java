package com.app.financialmanagement.configuration.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.app.financialmanagement.swagger")
@Data
public class OpenApiConfigurationProperties {
    private Properties properties = new Properties();

    @Data
    public class Properties{
        private String title;
        private String description;
        private String apiVersion;

        private Contact contact = new Contact();
        private Security security = new Security();

        @Data
        public class Contact {
            private String email;
            private String name;
            private String url;
        }

        @Data
        public class Security{
            private String name;
            private String scheme;
            private String bearerFormat;
        }
    }
}
