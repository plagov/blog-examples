package io.plagov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AncestorTest {

    private final AncestorRuleEngine ruleEngine = new AncestorRuleEngine();

    @Test
    void executeSelectorWithTag() {
        var selectorWithTag = "div";
        var ancestorXpath = ruleEngine.process(selectorWithTag).value();
        assertEquals("ancestor::div", ancestorXpath);
    }

    @Test
    void executeSelectorWithClass() {
        var selectorWithClass = ".class";
        var ancestorXpath = ruleEngine.process(selectorWithClass).value();
        assertEquals(
                "ancestor::*[contains(concat(' ', normalize-space(@class), ' '), ' class ')]",
                ancestorXpath
        );
    }

    @Test
    void executeSelectorWithAttribute() {
        var selectorWithAttribute = "[data-test]";
        var ancestorXpath = ruleEngine.process(selectorWithAttribute).value();
        assertEquals(
                "ancestor::*[@data-test]",
                ancestorXpath
        );
    }

    @Test
    void executeSelectorWithAttributeAndValue() {
        var selectorWithAttributeAndValue = "[data-test=data-value]";
        var ancestorXpath = ruleEngine.process(selectorWithAttributeAndValue).value();
        assertEquals(
                "ancestor::*[@data-test='data-value']",
                ancestorXpath
        );
    }

    @Test
    void executeInvalidSelector() {
        var invalidSelector = "div[data-test='data-value']";
        var exception =
                assertThrows(IllegalArgumentException.class, () -> ruleEngine.process(invalidSelector));
        assertEquals(exception.getMessage(), "Selector does not match any rule");
    }
}
