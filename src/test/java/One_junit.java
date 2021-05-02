import com.inet.timemodel.domain.RoleModel;
import com.inet.timemodel.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class One_junit {

    /**
     * C3P0成功运行
     * @author HCY
     * @since 2021/3/16 下午10:22
     * @return void
    */
    @Test
    public void test_GetDataSource() throws SQLException {
        System.out.println(DataSourceUtils.getConnection());
        System.out.println(DataSourceUtils.getDataSource());
    }

    /**
     * 查询
     * @return void
    */
    @Test
    public void test_C3P0() {
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
        for ( RoleModel roleModel : list ) {
            System.out.println(roleModel);
        }

    }
}
