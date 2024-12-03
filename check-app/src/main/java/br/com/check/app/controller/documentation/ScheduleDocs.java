package br.com.check.app.controller.documentation;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface ScheduleDocs {

    @Operation(summary = "Create Schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Creating a Schedule",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    UUID createSchedule(ScheduleForm scheduleDto) throws JsonProcessingException;

    @Operation(summary = "Update schedule date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update schedule date",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ScheduleDto updateDate(UUID uuid, OffsetDateTime dateTime);

    @Operation(summary = "Get All Exams From a Schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get All Exams From a Schedule",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    List<ExamDto> getAllExams(UUID uuid);

    @Operation(summary = "Delete schedule")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete schedule by uuid",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ScheduleDto deleteSchedule(UUID uuid);

    @Operation(summary = "Get schedule by uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get schedule by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ScheduleDto getSchedule(UUID uuid);

}
