package net.ddns.ziehlke.eletopo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {
    private UserDto userDto;
    private Route route;
    private Grade userGrade;
}
