package io.plagov.rules;

import java.util.Optional;

public class AncestorWithClassRule extends SelectorValidation implements AncestorRule {

    @Override
    public Optional<AncestorResult> evaluate(String selector) {
        if (isCssClass(selector)) {
            String xpath = "ancestor::*[contains(concat(' ', normalize-space(@class), ' '), ' %s ')]"
                    .formatted(selector.substring(1));
            return Optional.of(new AncestorResult(xpath));
        }
        return Optional.empty();
    }
}
