package com.inet.timemodel.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * C3P0工具类
 * @author HCY
 * @since 2021/3/15 下午1:56
*/
public class DataSourceUtils {
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    /**
     * 获取连接池对象
     * @return javax.sql.DataSource
    */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 从线程中获取连接
     * @throws SQLException
     * @return java.sql.Connection
    */
    public static Connection getConnection() throws SQLException {
        //从线程中获取到连接
        Connection conn = tl.get();
        //问: 如果我们是第一次获取连接呢？
        //答：需要从连接池中获取到一个连接，并且将这个连接和当前的线程进行绑定操作
        if (conn == null){
            //从连接池中获取连接
            conn = ds.getConnection();
            //绑定连接
            tl.set(conn);
        }
        //返回连接
        return conn;
    }

    /**
     * 释放结果集
     * @param rs: 结果集
     * @return void
    */
    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            rs = null;
        }
    }

    /**
     * 释放语句执行者
     * @param st: 语句执行者
     * @return void
    */
    public static void closeStatement(Statement st){
        if (st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            st = null;
        }
    }

    /**
     * 释放连接
     * @param conn: 连接对象
     * @return void
    */
    public static void closeConn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            conn = null;
        }
    }

    /**
     * 释放资源
     * @param conn:连接对象
     * @param st: 语句执行者
     * @param rs: 结果集
     * @return void
    */
    public static void closeResource(Connection conn,Statement st,ResultSet rs){
        closeResultSet(rs);
        closeStatement(st);
        closeConn(conn);
    }

    /**
     * 开始进行事务
     * @return void
    */
    public static void stateTransaction() throws SQLException {
        //1.获取连接
        Connection connection = getConnection();
        //2.开始
        connection.setAutoCommit(false);
    }

    /**
     * 事务提交
     * @return void
    */
    public static void commitAndClose() {
        //1. 获取连接
        Connection connection = null;
        try {
            connection = getConnection();
            //2.提交事务
            connection.commit();
            //3.关闭
            closeConn(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 事务回滚
     * @return void
    */
    public static void rollbackAndClose(){

        Connection connection = null;
        try {
            //获取连接
            connection = getConnection();
            //事务回滚
            connection.rollback();
            //关闭
            closeConn(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
