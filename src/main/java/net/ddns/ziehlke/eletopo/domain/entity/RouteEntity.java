package net.ddns.ziehlke.eletopo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import net.ddns.ziehlke.eletopo.model.Grade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@Entity
public class RouteEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Grade grade;
    private int lineNo;
    private LocalDate dateOfCreation;

}
