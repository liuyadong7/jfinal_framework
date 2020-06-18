package com.useradmin.framework.config.mapping;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.demo.common.model.Blog;
import com.jfinal.config.Plugins;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.dialect.*;
import com.jfinal.plugin.druid.DruidPlugin;
import com.useradmin.common.base.BaseMapping;
import com.useradmin.common.constant.ConstantInit;
import com.useradmin.common.dto.DataBase;
import com.useradmin.common.enums.Driver;
import com.useradmin.common.tools.ToolDataBase;
import org.apache.log4j.Logger;

public class UserAdminMapping extends BaseMapping {

    private static Logger log = Logger.getLogger(UserAdminMapping.class);

    /**
     * 数据库的连接处理
     *
     * @param plugins
     */
    public UserAdminMapping(Plugins plugins) {

        log.info("configPlugin 配置Druid数据库连接池连接属性");
        Driver driver = Enum.valueOf(Driver.class, PropKit.get(ConstantInit.jfinal_datasource_db));
        DataBase db = ToolDataBase.getDbInfo(driver);
        String driverClass = db.getDriverClass();
        String jdbcUrl = db.getJdbcUrl();
        String username = db.getUserName();
        String password = db.getPassWord();

        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrl, username, password, driverClass);

        log.info("configPlugin 配置Druid数据库连接池大小");
        druidPlugin.set(PropKit.getInt(ConstantInit.datasource_db_initialSize), PropKit.getInt(ConstantInit.datasource_db_minIdle),
                PropKit.getInt(ConstantInit.datasource_db_maxActive));

        log.info("configPlugin 配置Druid数据库连接池过滤器配制");
        druidPlugin.addFilter(new StatFilter());
        WallFilter wall = new WallFilter();
        wall.setDbType(PropKit.get(ConstantInit.jfinal_datasource_db));
        WallConfig config = new WallConfig();
        config.setFunctionCheck(false); // 支持数据库函数
        wall.setConfig(config);
        druidPlugin.addFilter(wall);

        log.info("注册useradmin ActiveRecordPlugin");
        log.info("configPlugin 配置ActiveRecordPlugin插件");
//        configName = ConstantInit.db_dataSource_main;
//        arp = new ActiveRecordPlugin(configName, druidPlugin);
        arp = new ActiveRecordPlugin(druidPlugin); // 临时处理
//        arp.setTransactionLevel(4);//事务隔离级别
        boolean devMode = Boolean.parseBoolean(PropKit.get(ConstantInit.config_constants_devMode));
        arp.setDevMode(devMode); // 设置开发模式
        arp.setShowSql(devMode); // 是否显示SQL
        arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));// 大小写不敏感

        log.info("configPlugin 数据库类型判断");

        switch (driver) {
            case postgresql:

                log.info("configPlugin 使用数据库类型是 postgresql");
                arp.setDialect(new PostgreSqlDialect());
                break;
            case mysql:

                log.info("configPlugin 使用数据库类型是 mysql");
                arp.setDialect(new MysqlDialect());
                break;
            case oracle:

                log.info("configPlugin 使用数据库类型是 oracle");
                druidPlugin.setValidationQuery("select 1 FROM DUAL"); // 连接验证语句
                arp.setDialect(new OracleDialect());
                break;
            case sqlserver:

                log.info("configPlugin 使用数据库类型是 sqlserver");
                arp.setDialect(new SqlServerDialect());
                break;
            case db2:

                log.info("configPlugin 使用数据库类型是 db2");
                druidPlugin.setValidationQuery("select 1 from sysibm.sysdummy1"); // 连接验证语句
                arp.setDialect(new AnsiSqlDialect());
                break;
        }

        log.info("configPlugin 添加druidPlugin插件");
        plugins.add(druidPlugin); // 多数据源继续添加

        log.info("configPlugin 表自动扫描映射");
        scan();

        log.info("configPlugin 表手工注册");
        userAdminMapping();

        log.info("configPlugin 注册ActiveRecordPlugin插件");
        plugins.add(arp);
    }

    /**
     * 手动添加映射
     */
    private void userAdminMapping() {
        arp.addMapping("blog", Blog.class);
        //arp.addMapping("fg_recruit", "ids", Recruit.class);
        //arp.addMapping("fg_recruit", Recruit.class);
    }

}