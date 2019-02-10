package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.VoteEntity;
import net.ddns.ziehlke.eletopo.domain.repository.VoteRepository;
import net.ddns.ziehlke.eletopo.model.Vote;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final UserService userService;
    private final RouteService routeService;

    public Vote map(VoteEntity voteEntity) {
        return Vote.builder()
                .userDto(userService.map(voteEntity.getUserEntity()))
                .route(routeService.map(voteEntity.getRouteEntity()))
                .userGrade(voteEntity.getUserGrade())
                .build();
    }

    public VoteEntity map(Vote vote) {
        return VoteEntity.builder()
                .userEntity(userService.map(vote.getUserDto()))
                .routeEntity(routeService.map(vote.getRoute()))
                .userGrade(vote.getUserGrade())
                .build();
    }


    public Vote save(Vote vote) {
        return map(voteRepository.save(map(vote)));
    }


    public Set<Vote> findByUserEntityEmail(String email) {
        return voteRepository.findByUserEntityEmail(email).stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }

    public Set<Vote> findByUserEntity_Id(UUID id) {
        return voteRepository.findByUserEntity_Id(id).stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }

    public Set<Vote> findByRouteEntity_Id(UUID id) {
        return voteRepository.findByRouteEntity_Id(id).stream()
                .map(this::map)
                .collect(Collectors.toSet());
    }

}
