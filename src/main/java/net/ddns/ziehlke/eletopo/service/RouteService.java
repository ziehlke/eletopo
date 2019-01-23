package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.entity.RouteEntity;
import net.ddns.ziehlke.eletopo.domain.repository.RouteRepository;
import net.ddns.ziehlke.eletopo.model.Route;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteService {
    public final RouteRepository routeRepository;

    public Route map(RouteEntity routeEntity) {
        return Route.builder()
                .name(routeEntity.getName())
                .grade(routeEntity.getGrade())
                .lineNo(routeEntity.getLineNo())
                .dateOfCreation(routeEntity.getDateOfCreation())
                .build();
    }

    public RouteEntity map(Route route) {
        return RouteEntity.builder()
                .name(route.getName())
                .grade(route.getGrade())
                .lineNo(route.getLineNo())
                .dateOfCreation(route.getDateOfCreation())
                .build();
    }


    public void save (Route route) {
        routeRepository.save(map(route));
    }

}
