package net.ddns.ziehlke.eletopo.service;

import lombok.AllArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.entity.UserEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import net.ddns.ziehlke.eletopo.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserDto map(UserEntity userEntity) {
        return UserDto.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .build();
    }

    public UserEntity map(UserDto userDto) {
        return UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

    public UserDto save(UserDto userDto) {
        if (findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("User already registered!");
        }
        return map(userRepository.save(map(userDto)));
    }


    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email).map(this::map);
    }

}
