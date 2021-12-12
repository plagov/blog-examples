package io.plagov.rules;

import java.util.Optional;

public class AncestorWithTagRule extends SelectorValidation implements AncestorRule {

    @Override
    public Optional<AncestorResult> evaluate(String selector) {
        if (!isCssClass(selector) && !isAttribute(selector) && !containsAttributeValue(selector)) {
            String xpath = "ancestor::%s".formatted(selector);
            return Optional.of(new AncestorResult(xpath));
        }
        return Optional.empty();
    }
}
