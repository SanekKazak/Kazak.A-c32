package org.spring.hometask47ilcontrolhotel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonError extends RuntimeException{
    private String code;
    private List<CommonError> commonErrors;
}
