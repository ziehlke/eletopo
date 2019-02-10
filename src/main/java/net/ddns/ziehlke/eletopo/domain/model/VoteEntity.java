package net.ddns.ziehlke.eletopo.domain.model;

import lombok.Builder;
import lombok.Data;
import net.ddns.ziehlke.eletopo.model.Grade;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Data
@Builder
@Entity
public class VoteEntity {
    @EmbeddedId
    private VoteEntityID id;

    @ManyToOne
    @MapsId("userId")
    private UserEntity userEntity;

    @ManyToOne
    @MapsId("routeId")
    private RouteEntity routeEntity;

    private Grade userGrade;
}
