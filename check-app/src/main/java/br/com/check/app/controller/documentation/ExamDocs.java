package br.com.check.app.controller.documentation;


import br.com.check.app.dto.ExamDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;

public interface ExamDocs {

    @Operation(summary = "Find exam by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Find an exam",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    ExamDto findExamById(@PathVariable("uuid") UUID uuid);

    @Operation(summary = "Delete an exam")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete an exam",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    void deleteExamById(@PathVariable("uuid") UUID uuid);
}
