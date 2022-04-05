package com.everglow.ruleengine.groovy;

import com.everglow.ruleengine.api.RuleEngine;
import com.everglow.ruleengine.core.DefaultRuleEngine;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GroovyRuleFactoryTest {

    @Test
    public void createGroovyRule_Test(){
        String groovyPath = "src/test/resources/CreateGroovyRuleTest.groovy";
        GroovyRule groovyRule = GroovyRuleFactory.createGroovyRule("createGroovyRule_Test", "createGroovyRule_Test", "ruleCondition", "ruleAction", new File(groovyPath));
        Assertions.assertThat(groovyRule.getGroovyObject()).isNotNull();
        log.info("createGroovyRule_Test:{}",groovyRule);
        Map<String,Object> map = new HashMap<>();
        map.put("name","iverson");
        RuleEngine ruleEngine = new DefaultRuleEngine();
        ruleEngine.fireRule(groovyRule,map);
        log.info("map:{}",map);
    }

}
