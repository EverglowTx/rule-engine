package com.everglow.ruleengine.core;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class DefaultRule extends AbstractRule{

    @Override
    public boolean judge(Map<String, Object> facts) {
        return false;
    }

    @Override
    public void execute(Map<String,Object> facts) throws Exception {

    }
}
