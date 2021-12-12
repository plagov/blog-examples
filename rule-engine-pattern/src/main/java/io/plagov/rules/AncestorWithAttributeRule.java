package io.plagov.rules;

import java.util.Optional;

public class AncestorWithAttributeRule extends SelectorValidation implements AncestorRule {

    @Override
    public Optional<AncestorResult> evaluate(String selector) {
        if (isAttribute(selector) && !containsAttributeValue(selector)) {
            String attribute = selector.substring(1, selector.length() - 1);
            String xpath = "ancestor::*[@%s]".formatted(attribute);
            return Optional.of(new AncestorResult(xpath));
        }
        return Optional.empty();
    }
}
