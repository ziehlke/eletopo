package net.ddns.ziehlke.eletopo.service;

import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.validation.EmailExistsException;

public interface IUserService {
    UserDto save(UserDto userDto) throws EmailExistsException;
}

