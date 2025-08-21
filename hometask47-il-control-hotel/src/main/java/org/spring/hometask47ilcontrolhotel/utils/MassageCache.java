package org.spring.hometask47ilcontrolhotel.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.hometask47ilcontrolhotel.exception.CommonError;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

@Component
@Getter
@RequiredArgsConstructor
public class MassageCache {
    private final ObjectMapper mapper;
    private Map<String, String> massageCache;
    private final Logger logger = LoggerFactory.getLogger("MassageCache");

    @PostConstruct
    private void initCache(){
        logger.info("error massages start initiating");
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("static/massages.json")) {
            massageCache = mapper.readValue(is, new TypeReference<Map<String, String>>() {});
        } catch (Exception e) {
            logger.error("error massages initiating stoped");
            throw new CommonError("0");
        }
    }

    public String get(String code){
        return massageCache.get(code);
    }
}
