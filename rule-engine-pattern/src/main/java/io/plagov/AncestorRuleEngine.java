package io.plagov;

import io.plagov.rules.AncestorResult;
import io.plagov.rules.AncestorRule;
import io.plagov.rules.AncestorWithAttributeAndValueRule;
import io.plagov.rules.AncestorWithAttributeRule;
import io.plagov.rules.AncestorWithClassRule;
import io.plagov.rules.AncestorWithTagRule;

import java.util.List;
import java.util.Optional;

public class AncestorRuleEngine {

    private static final List<AncestorRule> rules = List.of(
            new AncestorWithTagRule(),
            new AncestorWithClassRule(),
            new AncestorWithAttributeRule(),
            new AncestorWithAttributeAndValueRule()
    );

    public AncestorResult process(String selector) {
        return rules
                .stream()
                .map(rule -> rule.evaluate(selector))
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Selector does not match any rule"));
    }
}
