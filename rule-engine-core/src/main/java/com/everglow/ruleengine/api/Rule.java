package com.everglow.ruleengine.api;

import java.util.Map;

public interface Rule {

    /**
     * Executes the condition of the current rule based on the given fact, returns whether the condition is true
     * The implementation class should handle the exception itself and return the corresponding result
     * @return true or false
     */
    boolean judge(Map<String,Object> facts);

    /**
     * Execute the action of the current rule, if the judge method returns true
     * @throws Exception Throws any exception that occurs during execution
     */
    void execute(Map<String,Object> facts) throws Exception;

}
