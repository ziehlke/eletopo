package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.RouteEntity;
import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import net.ddns.ziehlke.eletopo.domain.model.VoteEntity;
import net.ddns.ziehlke.eletopo.domain.repository.UserRepository;
import net.ddns.ziehlke.eletopo.model.Grade;
import net.ddns.ziehlke.eletopo.model.Route;
import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.validation.EmailExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RouteService routeService;

    private UserDto map(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    private UserEntity map(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userEntity;
    }

    @Override
    public UserDto save(UserDto userDto) throws EmailExistsException {
        if (null == userRepository.findByEmail(userDto.getEmail())) {
            return map(userRepository.save(map(userDto)));
        } else {
            throw new EmailExistsException("Given e-mail is already registered");
        }
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public void addVote(String userEmail, Route route, Grade userGrade) {
        UserEntity userEntity = findByEmail(userEmail);
        RouteEntity routeEntity = routeService.map(route);

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setUserEntity(userEntity);
        voteEntity.setRouteEntity(routeEntity);
        voteEntity.setUserGrade(userGrade);

        userEntity.getVotedRoutes().add(voteEntity);
        routeEntity.getVotedUsers().add(voteEntity);


        userRepository.save(userEntity);
        routeService.save(routeEntity);
    }

    public void removeVote(UserDto userDto, Route route) {
        UserEntity userEntity = map(userDto);
        RouteEntity routeEntity = routeService.map(route);

        for (Iterator<VoteEntity> iterator = userEntity.getVotedRoutes().iterator();
             iterator.hasNext(); ) {
            VoteEntity voteEntity = iterator.next();

            if (voteEntity.getUserEntity().equals(this) &&
                    voteEntity.getRouteEntity().equals(routeEntity)) {
                iterator.remove();
                voteEntity.getRouteEntity().getVotedUsers().remove(voteEntity);
                voteEntity.setUserEntity(null);
                voteEntity.setRouteEntity(null);
                voteEntity.setUserGrade(null);
            }
        }
    }
}
