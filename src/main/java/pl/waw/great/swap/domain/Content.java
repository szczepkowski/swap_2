package pl.waw.great.swap.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Content {
    private Form form;
    private int value;
}
