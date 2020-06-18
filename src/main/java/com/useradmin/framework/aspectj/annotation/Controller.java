package com.useradmin.framework.aspectj.annotation;

import java.lang.annotation.*;

/**
 * 控制器注解
 * 说明：标注Controller和访问路径（自定义路径）
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Controller {
	
	/**
	 * 控制器路径，可以配置多个路径数组
	 * @return
	 */
    String[] controllerKey();

}