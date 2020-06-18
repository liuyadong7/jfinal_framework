package com.useradmin.common.base;

import com.jfinal.core.Controller;
import com.useradmin.common.dto.SplitPage;
import com.useradmin.project.system.syslog.Syslog;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * 公共的Controller
 *
 */
public class BaseController extends Controller {

    private static Logger log = Logger.getLogger(BaseController.class);

    //主键
    protected String ids;
    //分页封装
    protected SplitPage splitPage;
    //公共list
    protected List<?> list;
    //记录日志
    protected Syslog syslog;




}
