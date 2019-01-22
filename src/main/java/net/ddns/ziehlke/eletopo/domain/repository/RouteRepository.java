package net.ddns.ziehlke.eletopo.domain.repository;

import net.ddns.ziehlke.eletopo.domain.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RouteRepository extends JpaRepository<RouteEntity, UUID> {
}
