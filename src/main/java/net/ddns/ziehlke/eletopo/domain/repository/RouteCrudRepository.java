package net.ddns.ziehlke.eletopo.domain.repository;

import net.ddns.ziehlke.eletopo.domain.entity.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RouteCrudRepository extends CrudRepository<RouteEntity, UUID> {
}
