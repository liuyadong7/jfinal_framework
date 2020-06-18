package com.useradmin.common.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Table;
import com.jfinal.plugin.activerecord.TableMapping;
import org.apache.log4j.Logger;

/**
 * Model基础类
 *
 * @param <M>
 * @since 抽取公共方法，并重写save、update、getDate方法
 */
public class BaseModel<M extends BaseModel<M>> extends Model<M> implements IBean {

    private static final long serialVersionUID = -900378319414539856L;

    private static Logger log = Logger.getLogger(BaseModel.class);

    /**
     * 字段描述：版本号
     * 字段类型 ：bigint
     */
     String column_version = "version";

    /**
     * sqlId : admin.baseModel.select
     * 描述：通用查询
     */
     String sqlId_select = "admin.baseModel.select";

    /**
     * sqlId : admin.baseModel.update
     * 描述：通用更新
     */
     String sqlId_update = "admin.baseModel.update";

    /**
     * sqlId : admin.baseModel.delete
     * 描述：通用删除
     */
     String sqlId_delete = "admin.baseModel.delete";

    /**
     * sqlId : admin.baseModel.deleteIn
     * 描述：通用删除
     */
     String sqlId_deleteIn = "admin.baseModel.deleteIn";

    /**
     * sqlId : admin.baseModel.deleteOr
     * 描述：通用删除
     */
     String sqlId_deleteOr = "admin.baseModel.deleteOr";

    /**
     * sqlId : admin.baseModel.splitPageSelect
     * 描述：通用select *
     */
     String sqlId_splitPageSelect = "admin.baseModel.splitPageSelect";

    /**
     * 获取表映射对象
     *
     * @return
     */
    protected Table getTable() {
        return TableMapping.me().getTable(getClass());
    }

}
