package com.pluxurydolo.scope.persistent.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersistentScope implements Scope {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistentScope.class);
    private static final Map<String, Object> BEANS = new ConcurrentHashMap<>();

    public static final String PERSISTENT_SCOPE = "persistent-scope";

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return BEANS.computeIfAbsent(name, _ -> {
            LOGGER.info("dsbo [persistent-scope-spring-boot-starter] Бин {} не найден и будет создан", name);
            return objectFactory.getObject();
        });
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return PERSISTENT_SCOPE;
    }
}
