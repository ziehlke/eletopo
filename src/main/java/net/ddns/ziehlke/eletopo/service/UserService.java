package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import net.ddns.ziehlke.eletopo.model.UserDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto map(UserEntity userEntity) {
        return UserDto.builder()
                .email(userEntity.getEmail())
                .build();
    }

    public UserEntity map(UserDto userDto) {
        return UserEntity.builder()
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

    public UserDto save(UserDto userDto) throws Exception {
        if (null == userRepository.findByEmail(userDto.getEmail())) {
            return map(userRepository.save(map(userDto)));
        } else {
            throw new Exception("User already exists");
        }
    }

    public UserDto findByEmail(String email) {
        return map(userRepository.findByEmail(email));
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByEmail(email);
//        return User.builder()
//                .username(userEntity.getEmail())
//                .password(userEntity.getPassword())
//                .disabled(false)
//                .accountExpired(false)
//                .credentialsExpired(false)
//                .accountLocked(false)
//                .authorities("USER")
//                .build();
//    }
}
