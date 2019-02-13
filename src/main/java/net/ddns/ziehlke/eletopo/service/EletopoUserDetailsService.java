package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EletopoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userRepository.findByEmail(email) == null) {
            throw new UsernameNotFoundException("No user registered with given e-mail.");
        }
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

    //    // TODO: implement ROLES
////    private static List<GrantedAuthority> getAuthorities(List<String> roles) {
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        for (String role : roles) {
////            authorities.add(new SimpleGrantedAuthority(role));
////        }
////        return authorities;
////    }
}
