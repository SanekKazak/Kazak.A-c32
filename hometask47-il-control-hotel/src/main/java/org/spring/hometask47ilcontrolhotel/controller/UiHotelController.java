package org.spring.hometask47ilcontrolhotel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.spring.hometask47ilcontrolhotel.dto.ErrorDto;
import org.spring.hometask47ilcontrolhotel.dto.HotelDto;

import java.util.List;
import java.util.UUID;

public interface UiHotelController {
    @Operation(summary = "get all hotels", description = "can show all hotels with book opportunities", tags = "get",
            responses = {
                    @ApiResponse(description = "all good", responseCode = "200", content = @Content(array = @ArraySchema(schema = @Schema(implementation = HotelDto.class)))),
                    @ApiResponse(description = "no one hotel founded", responseCode = "505", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(description = "unexpected error", responseCode = "500", content = @Content())
            }
    )
    List<HotelDto> getAll();
    @Operation(summary = "register hotel", description = "u can register personal hotel", tags = "create",
            responses = {
                    @ApiResponse(description = "all good", responseCode = "200", content = @Content(schema = @Schema(implementation = HotelDto.class))),
                    @ApiResponse(description = "name should be not null", responseCode = "505", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ErrorDto.class)) )),
                    @ApiResponse(description = "unexpected error", responseCode = "500", content = @Content())
            }
    )
    HotelDto create(HotelDto dto);
    @Operation(summary = "delete hotel", description = "delete opportunity", tags = "delete",
            responses = {
                    @ApiResponse(description = "all good", responseCode = "200", content = @Content(schema = @Schema(implementation = HotelDto.class))),
                    @ApiResponse(description = "no one hotel with this id", responseCode = "505", content = @Content(schema = @Schema(implementation = ErrorDto.class))),
                    @ApiResponse(description = "unexpected error", responseCode = "500", content = @Content())
            }
    )
    HotelDto delete(UUID id);
}
