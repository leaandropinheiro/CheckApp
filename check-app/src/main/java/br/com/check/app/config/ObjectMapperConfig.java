package br.com.check.app.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.ZoneOffset;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        this.defaults(objectMapper);
        this.configure(objectMapper);
        this.modules(objectMapper);

        return objectMapper;
    }

    private void defaults(final ObjectMapper objectMapper) {
        objectMapper.setTimeZone(TimeZone.getTimeZone(ZoneOffset.UTC))
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private void configure(final ObjectMapper objectMapper) {
        objectMapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, false)
            .configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    }

    private void modules(final ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
    }
}
