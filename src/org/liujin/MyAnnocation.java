package org.liujin;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author LiuJin
 * @date 2022-08-05 17:43
 */
@Target({FIELD, METHOD, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnocation {
    String[] value() default "JAMES";
}
