package com.pluxurydolo.scope.persistent.configuration;

import com.pluxurydolo.scope.persistent.scope.PersistentScope;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import static com.pluxurydolo.scope.persistent.scope.PersistentScope.PERSISTENT_SCOPE;

@AutoConfiguration
@Profile("test")
public class PersistentScopeAutoConfiguration {

    @Bean
    public static BeanFactoryPostProcessor scopeRegistrar(PersistentScope persistentScope) {
        return beanFactory -> beanFactory.registerScope(PERSISTENT_SCOPE, persistentScope);
    }

    @Bean
    public static PersistentScope testPersistentScope() {
        return new PersistentScope();
    }
}
