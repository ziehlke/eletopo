package net.ddns.ziehlke.eletopo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route {
    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private Grade authorGrade;

    @NotNull
    @NotEmpty
    @Min(0) @Max(20)
    private LineNo lineNo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfCreation = LocalDate.now();

    @NotNull
    @NotEmpty
    private String color;

    private boolean active = true;

    @Getter
    @AllArgsConstructor
    public enum LineNo {
        FIRST(1),
        SECOND(2),
        THIRD(3),
        FOURTH(4),
        FIFTH(5),
        SIXTH(6),
        SEVENTH(7),
        EIGHTH(8),
        NINTH(9),
        TENTH(10),
        ELEVENTH(11),
        TWELFTH(12),
        THIRTEENTH(13),
        FOURTEENTH(14),
        FIFTEENTH(15),
        SIXTEENTH(16),
        SEVENTEENTH(17),
        EIGHTEENTH(18),
        NINETEENTH(19),
        TWENTIETH(20),
        TWENTY_FIRST(21);

        private int lineNo;
        }

}
