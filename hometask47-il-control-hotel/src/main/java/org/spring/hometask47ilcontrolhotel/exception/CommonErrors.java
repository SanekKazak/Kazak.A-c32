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
public class CommonErrors extends RuntimeException{
    private List<CommonError> commonErrors;
}
