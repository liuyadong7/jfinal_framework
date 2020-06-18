package com.useradmin.project.system.syslog;

import org.apache.log4j.Logger;

import java.sql.Timestamp;

/**
 * 日志model
 * @author 董华健
 */
@SuppressWarnings("unused")
//@Table(tableName = "pt_syslog")
public class Syslog /*extends BaseModel<Syslog> */{
	
	private static final long serialVersionUID = 2051998642258015518L;

	private static Logger log = Logger.getLogger(Syslog.class);
	
	 Syslog dao = new Syslog();

	/**
	 * 字段描述：主键 
	 * 字段类型 ：character varying 
	 */
	 String column_ids = "ids";
	
	/**
	 * 字段描述：版本号 
	 * 字段类型 ：bigint 
	 */
	 String column_version = "version";
	
	/**
	 * 字段描述：action结束时间 
	 * 字段类型 ：timestamp without time zone 
	 */
	 String column_actionenddate = "actionenddate";
	
	/**
	 * 字段描述：action结束时间 
	 * 字段类型 ：bigint 
	 */
	 String column_actionendtime = "actionendtime";
	
	/**
	 * 字段描述：action耗时 
	 * 字段类型 ：bigint 
	 */
	 String column_actionhaoshi = "actionhaoshi";
	
	/**
	 * 字段描述：action开始时间 
	 * 字段类型 ：timestamp without time zone 
	 */
	 String column_actionstartdate = "actionstartdate";
	
	/**
	 * 字段描述：action开始时间 
	 * 字段类型 ：bigint 
	 */
	 String column_actionstarttime = "actionstarttime";
	
	/**
	 * 字段描述：失败原因 : 0没有权限,1URL不存在,2未登录,3业务代码异常 
	 * 字段类型 ：character 
	 */
	 String column_cause = "cause";
	
	/**
	 * 字段描述：cookie数据 
	 * 字段类型 ：character varying 
	 */
	 String column_cookie = "cookie";
	
	/**
	 * 字段描述：描述 
	 * 字段类型 ：text 
	 */
	 String column_description = "description";
	
	/**
	 * 字段描述：结束时间 
	 * 字段类型 ：timestamp without time zone 
	 */
	 String column_enddate = "enddate";
	
	/**
	 * 字段描述：结束时间 
	 * 字段类型 ：bigint 
	 */
	 String column_endtime = "endtime";
	
	/**
	 * 字段描述：耗时 
	 * 字段类型 ：bigint 
	 */
	 String column_haoshi = "haoshi";
	
	/**
	 * 字段描述：客户端ip 
	 * 字段类型 ：character varying 
	 */
	 String column_ips = "ips";
	
	/**
	 * 字段描述：访问方法 
	 * 字段类型 ：character varying 
	 */
	 String column_method = "method";
	
	/**
	 * 字段描述：源引用 
	 * 字段类型 ：character varying 
	 */
	 String column_referer = "referer";
	
	/**
	 * 字段描述：请求路径 
	 * 字段类型 ：text 
	 */
	 String column_requestpath = "requestpath";
	
	/**
	 * 字段描述：开始时间 
	 * 字段类型 ：timestamp without time zone 
	 */
	 String column_startdate = "startdate";
	
	/**
	 * 字段描述：开始时间 
	 * 字段类型 ：bigint 
	 */
	 String column_starttime = "starttime";
	
	/**
	 * 字段描述：账号状态 
	 * 字段类型 ：character 
	 */
	 String column_status = "status";
	
	/**
	 * 字段描述：useragent 
	 * 字段类型 ：character varying 
	 */
	 String column_useragent = "useragent";
	
	/**
	 * 字段描述：视图耗时 
	 * 字段类型 ：bigint 
	 */
	 String column_viewhaoshi = "viewhaoshi";
	
	/**
	 * 字段描述：菜单对应功能ids 
	 * 字段类型 ：character varying 
	 */
	 String column_operatorids = "operatorids";
	
	/**
	 * 字段描述：accept 
	 * 字段类型 ：character varying 
	 */
	 String column_accept = "accept";
	
	/**
	 * 字段描述：acceptencoding 
	 * 字段类型 ：character varying 
	 */
	 String column_acceptencoding = "acceptencoding";
	
	/**
	 * 字段描述：acceptlanguage 
	 * 字段类型 ：character varying 
	 */
	 String column_acceptlanguage = "acceptlanguage";
	
	/**
	 * 字段描述：connection 
	 * 字段类型 ：character varying 
	 */
	 String column_connection = "connection";
	
	/**
	 * 字段描述：host 
	 * 字段类型 ：character varying 
	 */
	 String column_host = "host";
	
	/**
	 * 字段描述：xrequestedwith 
	 * 字段类型 ：character varying 
	 */
	 String column_xrequestedwith = "xrequestedwith";
	
	/**
	 * 字段描述：pvids 
	 * 字段类型 ：character varying 
	 */
	 String column_pvids = "pvids";
	
	/**
	 * 字段描述：访问用户ids 
	 * 字段类型 ：character varying 
	 */
	 String column_userids = "userids";

	/**
	 * sqlId : platform.sysLog.view
	 * 描述：
	 */
	 String sqlId_view = "platform.sysLog.view";

	/**
	 * sqlId : platform.sysLog.splitPageSelect
	 * 描述：分页select
	 */
	 String sqlId_splitPageSelect = "platform.sysLog.splitPageSelect";

	/**
	 * sqlId : platform.sysLog.splitPageFrom
	 * 描述：分页from
	 */
	 String sqlId_splitPageFrom = "platform.sysLog.splitPageFrom";

	/**
	 * sqlId : platform.sysLog.clear
	 * 描述：清除数据
	 */
	 String sqlId_clear = "platform.sysLog.clear";

	private String ids;
	private String version;
	private String actionenddate;
	private String actionendtime;
	private String actionhaoshi;
	private String actionstartdate;
	private String actionstarttime;
	private String cause;
	private String cookie;
	private String description;
	private String enddate;
	private String endtime;
	private String haoshi;
	private String ips;
	private String method;
	private String referer;
	private String requestpath;
	private String startdate;
	private String starttime;
	private String status;
	private String useragent;
	private String viewhaoshi;
	private String operatorids;
	private String accept;
	private String acceptencoding;
	private String acceptlanguage;
	private String connection;
	private String host;
	private String xrequestedwith;
	private String pvids;
	private String userids;
}
