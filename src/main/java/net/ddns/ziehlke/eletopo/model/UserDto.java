package net.ddns.ziehlke.eletopo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.validation.PasswordMatches;
import net.ddns.ziehlke.eletopo.validation.ValidEmail;
import net.ddns.ziehlke.eletopo.validation.ValidPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}

