package net.ddns.ziehlke.eletopo.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Grade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class VoteEntity {
    @EmbeddedId
    @EqualsAndHashCode.Exclude
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
    @EqualsAndHashCode.Exclude
    private Grade userGrade;
}
