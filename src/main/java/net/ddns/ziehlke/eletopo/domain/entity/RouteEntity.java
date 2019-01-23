package net.ddns.ziehlke.eletopo.domain.entity;

import lombok.*;
import net.ddns.ziehlke.eletopo.model.Grade;
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
    private int lineNo;
    private LocalDate dateOfCreation;

}
