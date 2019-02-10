package net.ddns.ziehlke.eletopo.service;

import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.validation.EmailExistsException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    UserDto save(UserDto userDto) throws EmailExistsException;
}

