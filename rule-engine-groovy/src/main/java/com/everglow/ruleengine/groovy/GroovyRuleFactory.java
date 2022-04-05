package com.everglow.ruleengine.groovy;


import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class GroovyRuleFactory {

    private GroovyRuleFactory() {
    }

    public static GroovyRule createGroovyRule(String name,String description,String condition,String action,File file) {
        GroovyRule rule = new GroovyRule();
        rule.setName(name);
        rule.setDescription(description);
        rule.setCondition(condition);
        rule.setAction(action);
        if (file.exists()) {
            GroovyClassLoader groovyClassLoader = SingletonGroovyClassLoader.getInstance();
            try {
                Class<?> parseClass = groovyClassLoader.parseClass(file);
                GroovyObject groovyObject = (GroovyObject) parseClass.newInstance();
                rule.setGroovyObject(groovyObject);
            } catch (IOException | InstantiationException | IllegalAccessException e) {
                log.warn("GroovyClassLoader parseClass Exception,fileName:{},filePath:{}", file.getName(), file.getPath(), e);
            }
        }
        return rule;
    }

    public static void main(String[] args) {
        log.info("!23");
    }

}
