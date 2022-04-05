package com.everglow.ruleengine.core;

import com.everglow.ruleengine.api.RuleEngine;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class DefaultRuleEngine implements RuleEngine {
    @Override
    public void fireRule(AbstractRule rule, Map<String, Object> facts) {
        boolean judge = rule.judge(facts);
        if (judge){
            try {
                rule.execute(facts);
            } catch (Exception e) {
                log.warn("{} rule({}) execute with exception:{}",rule.getName(),rule.getDescription(),e.getMessage(),e);
            }
        }else {
            log.info("{} rule({}) execute judge return false,skipped!",rule.getName(),rule.getDescription());
        }
    }

    @Override
    public void fireRules(List<AbstractRule> rules, Map<String, Object> facts) {
        rules.forEach(rule -> fireRule(rule,facts));
    }
}
