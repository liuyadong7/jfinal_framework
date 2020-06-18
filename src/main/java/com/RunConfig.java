package com;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;
import com.useradmin.common.constant.ConstantCache;
import com.useradmin.common.constant.ConstantInit;
import com.useradmin.common.plugin.ControllerPlugin;
import com.useradmin.common.tools.ToolString;
import com.useradmin.framework.config.mapping.UserAdminMapping;
import com.useradmin.framework.config.routes.UserAdminRoutes;
import live.autu.plugin.jfinal.swagger.config.SwaggerPlugin;
import org.apache.log4j.Logger;

/**
 * jfinal_framework的启动类
 * <p>
 * API 引导式配置
 *
 * @author 刘亚东
 */
public class RunConfig extends JFinalConfig {

    private static Logger log = Logger.getLogger(RunConfig.class);

    static {
        log.info("第一次读取配置文件");
        PropKit.use("jfinal.properties");
    }

    /**
     * 配置常量
     */
    public void configConstant(Constants constants) {
        /**
         * 支持 Controller、Interceptor、Validator 之中使用 @Inject 注入业务层，并且自动实现 AOP
         * 注入动作支持任意深度并自动处理循环注入
         */
        constants.setInjectDependency(true);

        // 配置对超类中的属性进行注入
        constants.setInjectSuperClass(true);

        // 使用slf4j（默认log4j）
        // constants.setToSlf4jLogFactory();

        log.info("configConstant 设置开发环境");
        PropKit.append(ToolString.ProfilesActive(ConstantInit.config_profiles_active));

        log.info("configConstant 设置是否开发模式");
        constants.setDevMode(PropKit.getBoolean(ConstantInit.config_constants_devMode, false));

        log.info("configConstant 设置字符集");
        constants.setEncoding(PropKit.get(ConstantInit.config_constants_encoding));
    }

    /**
     * 配置路由
     */
    public void configRoute(Routes routes) {

        log.info("configRoute 注解注册路由");
        new ControllerPlugin(routes).start();

        log.info("configRoute 手动注册路由");
        routes.add(new UserAdminRoutes());
    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins plugins) {

        log.info("注册useradmin ActiveRecordPlugin");
        new UserAdminMapping(plugins);

        log.info("RedisPlugin Redis缓存");
        String redisIp = PropKit.get(ConstantInit.config_redis_ip);
        Integer redisPort = PropKit.getInt(ConstantInit.config_redis_port);
        RedisPlugin systemRedis = new RedisPlugin(ConstantCache.cache_name_redis_system, redisIp, redisPort);
        plugins.add(systemRedis);

        log.info("Swagger的参数配置");
        plugins.add(new SwaggerPlugin());

        /*
        // 配置druid数据库连接池插件
        DruidPlugin druidPlugin = createDruidPlugin();
        plugins.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);

        // 所有映射在MappingKit中自动化搞定
        _MappingKit.mapping(arp);
        plugins.add(arp);
        */
    }

    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
        log.info("configInterceptor 权限认证拦截器");
    }

    public void configEngine(Engine me) {

        me.addSharedFunction("/wp/common/_layout.html");
        me.addSharedFunction("/wp/common/_paginate.html");
    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {

    }

    /**
     * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
     */
    /*public static void main(String[] args) {
        UndertowServer.start(DemoConfig.class);
    }*/

}