class CreateGroovyRuleTest {
    boolean ruleCondition(Map<String,Object> facts){
        if (facts.get("name").equals("iverson")){
            return true;
        }
        return false;
    }

    void ruleAction(Map<String,Object> facts){
        facts.put("age",24);
    }
}
