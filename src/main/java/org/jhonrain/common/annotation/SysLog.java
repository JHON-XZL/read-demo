package org.jhonrain.common.annotation;

import java.lang.annotation.*;

/**
 * <p>功能描述</br>系统日志注解</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName happy-read
 * @date 2018/6/19 13:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String value() default "";
}
