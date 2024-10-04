package br.com.check.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link br.com.check.app.entity.User}
 */
@AllArgsConstructor
@Getter
public class UserDto {
    @NotNull
    private final String firstName;
    private final String lastName;
    private final String email;
    @NotBlank
    private final String password;
    private final List<ScheduleDto> schedule;
}