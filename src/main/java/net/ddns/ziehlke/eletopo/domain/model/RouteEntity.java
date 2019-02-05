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
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class RouteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Grade grade;
    @Enumerated(EnumType.ORDINAL)
    private Route.LineNo lineNo;
    private LocalDate dateOfCreation;
    private String color;
}
