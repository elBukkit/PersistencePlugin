package com.elmakers.mine.bukkit.persisted;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MigrateStep
{
    String id();

    String pluginVersion() default "";

    boolean reset() default false;

    String script() default "";

    String statement() default "";
}
