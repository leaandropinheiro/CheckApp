package br.com.check.app.controller.documentation;

import br.com.check.app.dto.UnitDto;
import br.com.check.app.dto.UnitExamDto;
import br.com.check.app.entity.Unit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UnitDocs {

    @Operation(summary = "Create Unit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Creating a unit",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    void unitCreation(@RequestParam String name,
                      @RequestParam String region,
                      @RequestParam String specialty,
                      @RequestParam String services);

    @Operation(summary = "Find unit by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find unit by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    UnitDto findUnitById(@PathVariable Long unitId);

    @Operation(summary = "Find unit exams by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find unit exams by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    List<UnitExamDto> findUnitExamsByUnitId(@PathVariable Long unitId);

    @Operation(summary = "Find all units")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find all units",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    List<UnitDto> findAllUnits();

    @Operation(summary = "Add exam into unit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Add exam into unit",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    void addExamIntoUnit(@PathVariable Long unitId,
                         @RequestBody List<UnitExamDto> unitExamDto);

}
