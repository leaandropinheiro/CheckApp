package br.com.check.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NotBlank
    private String password;
    @OneToMany(targetEntity = Schedule.class)
    private List<Schedule> schedule;

}
