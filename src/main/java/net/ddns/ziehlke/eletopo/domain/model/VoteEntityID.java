package net.ddns.ziehlke.eletopo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
public class VoteEntityID implements Serializable {
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "route_id")
    private UUID routeId;
}

