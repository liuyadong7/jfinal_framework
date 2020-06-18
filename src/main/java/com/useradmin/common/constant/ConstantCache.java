package com.useradmin.common.constant;

/**
 * 缓存
 */
public interface ConstantCache {
	
	/**
	 * 缓存类型redis
	 */
	String cache_type_redis = "redis";

	/**
	 * 系统缓存，主要是权限和数据字典等
	 */
	String cache_name_redis_system = "system";
	
	/**
	 * 业务缓存，主要是泰山惠玩网业务等
	 */
	String cache_name_redis_webapi = "tshuiwan";
}
