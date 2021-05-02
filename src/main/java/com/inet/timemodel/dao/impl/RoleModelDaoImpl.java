package com.inet.timemodel.dao.impl;

import com.inet.timemodel.dao.RoleModelDao;
import com.inet.timemodel.domain.RoleModel;
import com.inet.timemodel.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zjz
 */
public class RoleModelDaoImpl implements RoleModelDao {

    /**
     * @return java.util.List<com.inet.timemodel.domain.RoleModel>
     */
    @Override
    public List<RoleModel> getRoleModel() {
        //定义SQL语句
        String sql = "SELECT " +
                "roleModel.id AS id," +
                "roleModel.`name` AS `name`," +
                "roleModel.photo AS photo," +
                "roleModel.awarded_time AS awardedTime," +
                "roleModel.birthday AS birthday," +
                "roleModel.title_honor AS titleHonor," +
                "roleModel.produce_url AS produceUrl," +
                "roleModel.address AS address," +
                "roleModel.create_time AS createTime," +
                "roleModel.modify_time AS modifyTime " +
                "FROM tbl_role_model AS roleModel;";
        //构建QueryRunner
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        //执行SQL
        List<RoleModel> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<>(RoleModel.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
