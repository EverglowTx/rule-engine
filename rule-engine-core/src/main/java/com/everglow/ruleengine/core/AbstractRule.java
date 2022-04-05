package com.everglow.ruleengine.core;


import com.everglow.ruleengine.api.Rule;
import lombok.Data;

@Data
public abstract class AbstractRule implements Rule {

    private String name;

    private String description;

    private String condition;

    private String action;

}
