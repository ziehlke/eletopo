package net.ddns.ziehlke.eletopo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Grade;
import net.ddns.ziehlke.eletopo.model.Route;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RouteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String author;
    @Enumerated(EnumType.ORDINAL)
    private Grade authorGrade;
    @Enumerated(EnumType.ORDINAL)
    private Route.LineNo lineNo;
    private LocalDate dateOfCreation;
    private String color;
    private boolean active;

    @OneToMany(mappedBy = "routeEntity")
    private Set<VoteEntity> votes = new HashSet<>();
}
