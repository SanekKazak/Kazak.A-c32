package org.spring.hometask47ilcontrolhotel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.spring.hometask47ilcontrolhotel.exception.CommonError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class Hometask47IlControlHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hometask47IlControlHotelApplication.class, args);
    }

    @Bean
    public ObjectMapper mapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public ErrorDecoder decoder(@Autowired ObjectMapper mapper) {
        return (s, e) -> {
            try {
                List<CommonError> commonErrors = mapper.readValue(e.body().asInputStream(), new TypeReference<List<CommonError>>() {});
                CommonError commonError = new CommonError();
                commonError.setCommonErrors(commonErrors);
                return commonError;
            } catch (Exception ex) {
                return ex;
            }
        };
    }
}
