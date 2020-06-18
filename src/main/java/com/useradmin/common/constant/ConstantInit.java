package com.useradmin.common.constant;

/**
 * 初始配置文件对应的key
 *
 * @author 刘亚东
 * @description jfinal.properties
 */
public interface ConstantInit {

    /**
     * 开发环境
     */
    String config_profiles_active = "config.profiles.active";

    /**
     * 开发模式
     */
    String config_constants_devMode = "config.constants.devMode";

    /**
     * 设置字符集
     */
    String config_constants_encoding = "config.constants.encoding";

    /**
     * 数据源的处理
     */
    String jfinal_datasource_db = "jfinal.datasource.db";
    String jfinal_datasource_jdbcUrl = "jfinal.datasource.jdbcUrl";
    String jfinal_datasource_user = "jfinal.datasource.user";
    String jfinal_datasource_password = "jfinal.datasource.password";

    /**
     * 数据库连接池参数
     */
    String datasource_db_initialSize = "datasource.db.initialSize";
    String datasource_db_minIdle = "datasource.db.minIdle";
    String datasource_db_maxActive = "datasource.db.maxActive";

    /**
     * redis 配置
     */
    String config_redis_ip = "config.redis.ip";
    String config_redis_port = "config.redis.port";
    String config_redis_password = "config.redis.password";

//#################################################################################################

    /**
     * 扫描的包
     */
    String config_scan_package = "config.scan.package";

    /**
     * 扫描的jar
     */
    String config_scan_jar = "config.scan.jar";


    /**
     * 加密密钥
     */
    String config_securityKey_key = "config.securityKey";

    /**
     * 密码最大错误次数
     */
    String config_passErrorCount_key = "config.passErrorCount";

    /**
     * 密码错误最大次数后间隔登陆时间（小时）
     */
    String config_passErrorHour_key = "config.passErrorHour";

    /**
     * #文件上传大小限制 10 * 1024 * 1024 = 10M
     */
    String config_maxPostSize_key = "config.maxPostSize";

    /**
     * # cookie 值的时间
     */
    String config_maxAge_key = "config.maxAge";

    /**
     * # 不使用自动登陆时，最大超时时间，单位：分钟
     */
    String config_session_key = "config.session";

    /**
     * # 域名或者服务器IP，多个逗号隔开，验证Referer时使用
     */
    String config_domain_key = "config.domain";

    /**
     * mail 配置：邮件服务器地址
     */
    String config_mail_host = "config.mail.host";

    /**
     * mail 配置：邮件服务器端口
     */
    String config_mail_port = "config.mail.port";

    /**
     * mail 配置：邮件服务器账号
     */
    String config_mail_from = "config.mail.from";

    /**
     * mail 配置：邮件服务器名称
     */
    String config_mail_userName = "config.mail.userName";

    /**
     * mail 配置：邮件服务器密码
     */
    String config_mail_password = "config.mail.password";

    /**
     * mail 配置：接收邮件地址
     */
    String config_mail_to = "config.mail.to";

    /**
     *  缓存类型配置
     */
//	 String config_cache_type = "config.cache.type";


    /**
     * 国际化配置，资源文件前缀
     */
    String config_i18n_filePrefix = "config.i18n.filePrefix";

    /**
     * 当前数据库类型
     */
    String db_type_key = "db.type";

    /**
     * 当前数据库类型：postgresql
     */
    String db_type_postgresql = "postgresql";

    /**
     * 当前数据库类型：mysql
     */
    String db_type_mysql = "mysql";

    /**
     * 当前数据库类型：oracle
     */
    String db_type_oracle = "oracle";

    /**
     * 当前数据库类型：sqlserver
     */
    String db_type_sqlserver = "sqlserver";

    /**
     * 当前数据库类型：db2
     */
    String db_type_db2 = "db2";

    /**
     * 数据库连接参数：驱动
     */
    String db_connection_postgresql_driverClass = "postgresql.driverClass";

    /**
     * 数据库连接参数：连接URL
     */
    String db_connection_postgresql_jdbcUrl = "postgresql.jdbcUrl";

    /**
     * 数据库连接参数：用户名
     */
    String db_connection_postgresql_userName = "postgresql.userName";

    /**
     * 数据库连接参数：密码
     */
    String db_connection_postgresql_passWord = "postgresql.passWord";

    /**
     * 数据库连接参数：驱动
     */
    String db_connection_mysql_driverClass = "mysql.driverClass";

    /**
     * 数据库连接参数：连接URL
     */
    String db_connection_mysql_jdbcUrl = "mysql.jdbcUrl";

    /**
     * 数据库连接参数：用户名
     */
    String db_connection_mysql_userName = "mysql.userName";

    /**
     * 数据库连接参数：密码
     */
    String db_connection_mysql_passWord = "mysql.passWord";

    /**
     * 数据库连接参数：驱动
     */
    String db_connection_oracle_driverClass = "oracle.driverClass";

    /**
     * 数据库连接参数：连接URL
     */
    String db_connection_oracle_jdbcUrl = "oracle.jdbcUrl";

    /**
     * 数据库连接参数：用户名
     */
    String db_connection_oracle_userName = "oracle.userName";

    /**
     * 数据库连接参数：密码
     */
    String db_connection_oracle_passWord = "oracle.passWord";

    /**
     * 数据库连接参数：驱动
     */
    String db_connection_sqlserver_driverClass = "sqlserver.driverClass";

    /**
     * 数据库连接参数：连接URL
     */
    String db_connection_sqlserver_jdbcUrl = "sqlserver.jdbcUrl";

    /**
     * 数据库连接参数：用户名
     */
    String db_connection_sqlserver_userName = "sqlserver.userName";

    /**
     * 数据库连接参数：密码
     */
    String db_connection_sqlserver_passWord = "sqlserver.passWord";

    /**
     * 数据库连接参数：驱动
     */
    String db_connection_db2_driverClass = "db2.driverClass";

    /**
     * 数据库连接参数：连接URL
     */
    String db_connection_db2_jdbcUrl = "db2.jdbcUrl";

    /**
     * 数据库连接参数：用户名
     */
    String db_connection_db2_userName = "db2.userName";

    /**
     * 数据库连接参数：密码
     */
    String db_connection_db2_passWord = "db2.passWord";

    /**
     * 数据库连接池参数：初始化连接大小
     */
    String db_initialSize = "db.initialSize";

    /**
     * 数据库连接池参数：最少连接数
     */
    String db_minIdle = "db.minIdle";

    /**
     * 数据库连接池参数：最多连接数
     */
    String db_maxActive = "db.maxActive";

    /**
     * 主数据源名称：系统主数据源
     */
    String db_dataSource_main = "db.dataSource.main";

}
