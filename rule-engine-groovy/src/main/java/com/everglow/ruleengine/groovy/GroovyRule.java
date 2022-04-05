package com.everglow.ruleengine.groovy;

import com.everglow.ruleengine.core.AbstractRule;
import groovy.lang.GroovyObject;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Data
public class GroovyRule extends AbstractRule {

    private GroovyObject groovyObject;

    @Override
    public boolean judge(Map<String, Object> facts) {
        Object o = groovyObject.invokeMethod(this.getCondition(), facts);
        if (Objects.isNull(o)){
            return false;
        }
        return Boolean.parseBoolean(o.toString());
    }

    @Override
    public void execute(Map<String,Object> facts) throws Exception {
        groovyObject.invokeMethod(this.getAction(),facts);
    }
}
