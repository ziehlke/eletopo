package net.ddns.ziehlke.eletopo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    private Grade grade;
    private int lineNo;
    private LocalDate dateOfCreation;

}
