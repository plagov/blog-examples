package io.plagov.rules;

import java.util.Optional;

public interface AncestorRule {
    Optional<AncestorResult> evaluate(String selector);
}

