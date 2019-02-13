package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import net.ddns.ziehlke.eletopo.model.Grade;
import net.ddns.ziehlke.eletopo.model.Route;
import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.validation.EmailExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto map(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }

    public UserEntity map(UserDto userDto) {
        return UserEntity.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

    @Override
    public UserDto save(UserDto userDto) throws EmailExistsException {
        if (null == userRepository.findByEmail(userDto.getEmail())) {
            return map(userRepository.save(map(userDto)));
        } else {
            throw new EmailExistsException("Given e-mail is already registered");
        }
    }

    public UserDto findByEmail(String email) {
        return map(userRepository.findByEmail(email));
    }


    public void addRouteVote(Route route, Grade grade) {
    }

    public void removeVoteOnRoute(Route route) {
    }
}
