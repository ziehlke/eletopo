package net.ddns.ziehlke.eletopo.domain.repository;

import net.ddns.ziehlke.eletopo.domain.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
    UserEntity findByEmail(String email);
}
