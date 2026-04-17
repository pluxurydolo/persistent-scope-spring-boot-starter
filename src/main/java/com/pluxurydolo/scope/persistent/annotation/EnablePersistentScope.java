package com.pluxurydolo.scope.persistent.annotation;

import com.pluxurydolo.scope.persistent.config.PersistentScopeAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(PersistentScopeAutoConfiguration.class)
public @interface EnablePersistentScope {
}
