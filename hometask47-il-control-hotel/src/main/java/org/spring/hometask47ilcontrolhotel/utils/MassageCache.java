package org.spring.hometask47ilcontrolhotel.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

@Component
@Getter
@RequiredArgsConstructor
public class MassageCache {
    private final ObjectMapper mapper;
    private Map<String, String> massageCache;

    @PostConstruct
    private void initCache(){
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("static/massages.json")) {
            massageCache = mapper.readValue(is, new TypeReference<Map<String, String>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String code){
        return massageCache.get(code);
    }
}
