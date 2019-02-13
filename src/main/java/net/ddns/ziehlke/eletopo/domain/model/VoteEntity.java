package net.ddns.ziehlke.eletopo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Grade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
//@Builder
@NoArgsConstructor
@Entity
public class VoteEntity {
    @EmbeddedId
    private VoteEntityID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private UserEntity userEntity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routeId")
    private RouteEntity routeEntity;

    @Enumerated(EnumType.ORDINAL)
    private Grade userGrade;
}
