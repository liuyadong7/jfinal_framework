package com.useradmin.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DataBase implements Serializable {
	
	private static final long serialVersionUID = 7980276824979813474L;

	/**
	 * 数据库连接参数：驱动
	 */
	public String driverClass;
	
	/**
	 * 数据库连接参数：连接URL
	 */
	public String jdbcUrl;
	
	/**
	 * 数据库连接参数：用户名
	 */
	public String userName;
	
	/**
	 * 数据库连接参数：密码
	 */
	public String passWord;

	/**
	 * 数据库连接参数：数据库服务器IP
	 */
	public String ip;
	
	/**
	 * 数据库连接参数：数据库服务器端口
	 */
	public String port;
	
	/**
	 * 数据库连接参数：数据库名称
	 */
	public String dbName;
}
