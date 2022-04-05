package com.everglow.ruleengine.api;


import com.everglow.ruleengine.core.AbstractRule;

import java.util.List;
import java.util.Map;

public interface RuleEngine {

    void fireRule(AbstractRule rule, Map<String,Object> facts);

    void fireRules(List<AbstractRule> rules,Map<String,Object> facts);
}
