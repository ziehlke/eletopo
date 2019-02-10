package net.ddns.ziehlke.eletopo.domain.repository;

import net.ddns.ziehlke.eletopo.domain.model.VoteEntity;
import net.ddns.ziehlke.eletopo.domain.model.VoteEntityID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<VoteEntity, VoteEntityID> {
    Set<VoteEntity> findByUserEntityEmail(String email);
    Set<VoteEntity> findByUserEntity_Id(UUID id);
    Set<VoteEntity> findByRouteEntity_Id(UUID id);
}
