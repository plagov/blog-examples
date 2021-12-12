package io.plagov;

public class Ancestor {

    public String execute(String selector) {
        var ancestorRuleEngine = new AncestorRuleEngine();
        return ancestorRuleEngine.process(selector).value();
    }
}
