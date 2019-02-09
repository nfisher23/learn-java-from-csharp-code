package javatests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SimplePairWithBuilder {
    private int key;
    private String value;
}
