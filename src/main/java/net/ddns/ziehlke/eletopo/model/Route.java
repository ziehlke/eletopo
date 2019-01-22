package net.ddns.ziehlke.eletopo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {
    private String name;
    private Grade grade;
    private int lineNo;
    private LocalDate dateOfCreation;
}
