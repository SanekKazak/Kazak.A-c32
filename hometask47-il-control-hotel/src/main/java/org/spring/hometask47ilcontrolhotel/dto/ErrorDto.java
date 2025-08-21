package org.spring.hometask47ilcontrolhotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorDto {
    @Schema(description = "message that says about problem", example = "sorry request not correct", requiredMode = Schema.RequiredMode.REQUIRED)
    private String message;
    @Schema(description = "message id", example = "808101", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;
}
