package net.ddns.ziehlke.eletopo.domain.model;

import lombok.*;
import net.ddns.ziehlke.eletopo.model.Grade;
import net.ddns.ziehlke.eletopo.model.Route;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    @OneToMany(mappedBy = "routeEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<VoteEntity> votedUsers = new HashSet<>();
}
