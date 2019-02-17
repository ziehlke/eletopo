package net.ddns.ziehlke.eletopo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.validation.PasswordMatches;
import net.ddns.ziehlke.eletopo.validation.ValidEmail;
import net.ddns.ziehlke.eletopo.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PasswordMatches
public class UserDto {
    @ValidPassword
    @Size(min = 6, max = 30)
    private String password;

    @Size(min = 6, max = 30)
    private String matchingPassword;

    @NotNull
    @ValidEmail
    private String email;
}

