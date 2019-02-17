package net.ddns.ziehlke.eletopo.service;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.domain.model.RouteEntity;
import net.ddns.ziehlke.eletopo.domain.repository.RouteRepository;
import net.ddns.ziehlke.eletopo.model.Route;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public Route map(RouteEntity routeEntity) {
        return modelMapper.map(routeEntity, Route.class);
    }

    public RouteEntity map(Route route) {
        return modelMapper.map(route, RouteEntity.class);
    }

    public void save(Route route) {
        routeRepository.save(map(route));
    }

    public void save(RouteEntity routeEntity) {
        routeRepository.save(routeEntity);
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

    public Route findById(UUID id) throws Exception {
        return map(routeRepository.findById(id).orElseThrow(() -> new Exception("No route with given ID found.")));
    }
}
