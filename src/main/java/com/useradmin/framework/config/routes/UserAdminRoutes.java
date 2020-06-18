package com.useradmin.framework.config.routes;

import com.demo.blog.BlogController;
import com.demo.index.IndexController;
import com.jfinal.config.Routes;
import live.autu.plugin.jfinal.swagger.controller.SwaggerController;

public class UserAdminRoutes extends Routes  {

    @Override
    public void config() {

        // 配置默认的ViewPath
        setBaseViewPath("/WEB-INF/view");
        // 配置swagger的路由
        add("/swagger", SwaggerController.class);

        // add("/", IndexController.class, "/wp");	// 第三个参数为该Controller的视图存放路径
        add("/blog", BlogController.class);     // 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
    }

}
