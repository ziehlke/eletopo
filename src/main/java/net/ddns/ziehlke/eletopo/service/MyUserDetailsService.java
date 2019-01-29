package net.ddns.ziehlke.eletopo.service;


import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findByEmail(email).get();
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .disabled(false)
                .accountExpired(false)
                .credentialsExpired(false)
                .accountLocked(false)
                .authorities("USER")
                .build();
    }


}

