package net.ddns.ziehlke.eletopo.domain.repository;

import net.ddns.ziehlke.eletopo.domain.model.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RouteRepository extends JpaRepository<RouteEntity, UUID> {
    public List<RouteEntity> findAllByActiveIsTrue();
    public List<RouteEntity> findAllByActiveIsFalse();
}
