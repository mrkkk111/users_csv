package com.cx.users.csv.dao.users;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "phoneNumber")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    @NotEmpty
    private String firstName;

    @Column(nullable = false)
    @PastOrPresent
    @NotNull
    private LocalDate birthDate;

    @Column(nullable = true)
    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;

    public User(@NotEmpty String lastName, @NotEmpty String firstName, @PastOrPresent LocalDate birthDate, @Pattern(regexp = "[0-9]{9}") String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }
}
