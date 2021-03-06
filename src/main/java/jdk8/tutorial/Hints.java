package jdk8.tutorial;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 提示注解数组。
 *
 * @author dannong
 * @since 2016年10月27日
 */
@Target({TYPE, FIELD, METHOD, TYPE_PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface Hints {
    Hint[] value();
}
