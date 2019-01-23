package net.ddns.ziehlke.eletopo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    V("V", 5f),
    VPLUS("V+", 5.5f),
    VI("VI", 6f),
    VIPLUS("VI+", 6.5f),
    VI1("VI.1", 7f),
    VI1PLUS("VI.1+", 7.5f),
    VI2("VI.2", 8f),
    VI2PLUS("VI.2+", 8.5f),
    VI3("VI.3", 9f),
    VI3PLUS("VI.3+", 9.5f),
    VI4("VI.4", 10f),
    VI4PLUS("VI.4+", 10.5f),
    VI5("VI.5", 11f),
    VI5PLUS("VI.5+", 11.5f),
    VI6("VI.6", 12f);

    private String kurtyki;
    private float numberic;
}
