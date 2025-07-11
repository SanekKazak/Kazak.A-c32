package org.rides.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BackendErrorExceptionProxy {
    private final Map<String, Exception> errors = new HashMap<>();
    private Boolean EXIST = false;

    public void addError(String field, String message){
        errors.put(field, new Exception(message));
        EXIST=true;
    }

    public Boolean isExist(){
        return EXIST;
    }

    public String getAllErrorsData(){
        return errors.entrySet().stream()
                .map(el->el.getKey() + " | " + el.getValue().getMessage() + "\n")
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return getAllErrorsData();
    }
}
