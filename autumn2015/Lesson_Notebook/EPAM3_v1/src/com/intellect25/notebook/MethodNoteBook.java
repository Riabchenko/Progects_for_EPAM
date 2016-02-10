package com.intellect25.notebook;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The MethodNoteBook is interface to annotations of methods
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodNoteBook {

    /* assigns execution order */
    public int name() default -1;

    /* describe kind of operation*/
    public String description() default "";
}
