package com.everglow.ruleengine.groovy;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilerConfiguration;

public class SingletonGroovyClassLoader {

    private SingletonGroovyClassLoader(){}

    private static volatile GroovyClassLoader groovyClassLoader;

    public static GroovyClassLoader getInstance(){
        if (groovyClassLoader == null){
            synchronized (SingletonGroovyClassLoader.class){
                if (groovyClassLoader == null){
                    CompilerConfiguration configuration = new CompilerConfiguration();
                    configuration.setSourceEncoding("UTF-8");
                    groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(),configuration);
                }
            }
        }
        return groovyClassLoader;
    }

}
