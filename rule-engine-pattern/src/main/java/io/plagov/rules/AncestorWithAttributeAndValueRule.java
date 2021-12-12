package io.plagov.rules;

import java.util.Optional;

import static java.lang.String.format;

public class AncestorWithAttributeAndValueRule extends SelectorValidation implements AncestorRule {

    @Override
    public Optional<AncestorResult> evaluate(String selector) {
        if (isAttribute(selector) && containsAttributeValue(selector)) {
            int endIndex = selector.indexOf("=");
            String attribute = selector.substring(1, endIndex);
            String attributeValue = selector.substring(endIndex + 1, selector.length() - 1);
            String xpath = "ancestor::*[@%s='%s']".formatted(attribute, attributeValue);
            return Optional.of(new AncestorResult(xpath));
        }
        return Optional.empty();
    }
}
