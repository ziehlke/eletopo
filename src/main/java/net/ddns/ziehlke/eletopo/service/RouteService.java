package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.RouteEntity;
import net.ddns.ziehlke.eletopo.domain.repository.RouteRepository;
import net.ddns.ziehlke.eletopo.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {
    public final RouteRepository routeRepository;

    public Route map(RouteEntity routeEntity) {
        return Route.builder()
                .name(routeEntity.getName())
                .author(routeEntity.getAuthor())
                .authorGrade(routeEntity.getAuthorGrade())
                .lineNo(routeEntity.getLineNo())
                .dateOfCreation(routeEntity.getDateOfCreation())
                .color(routeEntity.getColor())
                .active(routeEntity.isActive())
                .build();
    }

    public RouteEntity map(Route route) {
        return RouteEntity.builder()
                .name(route.getName())
                .author(route.getAuthor())
                .authorGrade(route.getAuthorGrade())
                .lineNo(route.getLineNo())
                .dateOfCreation(route.getDateOfCreation())
                .color(route.getColor())
                .active(route.isActive())
                .build();
    }

    public void save(Route route) {
        routeRepository.save(map(route));
    }

    public List<Route> findAll() {
        return routeRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public List<Route> findAllByActiveIsTrue() {
        return routeRepository.findAllByActiveIsTrue().stream().map(this::map).collect(Collectors.toList());
    }

    public List<Route> findAllByActiveIsFalse() {
        return routeRepository.findAllByActiveIsFalse().stream().map(this::map).collect(Collectors.toList());
    }
}
