package program;

import java.sql.*;
import java.util.List;

/**
 * @ClassName OracleUtil
 * @Author zhangqx02
 * @Date 2020/3/26 8:34
 * @Description
 * Oracle数据库工具类
 */

public class OracleUtil {
    /**
     * 获取Oracle数据库连接
     * @return connnetion
     */
    public static Connection getConnection(){
        Connection conn = null;

//        String url  = "jdbc:oracle:thin:@localhost:1521:test";//改格式数据库连接时一直报错
        String url = "jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT =1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME =test)))";
        String user = "crawlm";
        String passwd = "crawlm_Sd";

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,user,passwd);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("加载数据库启动失败！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败！");
        }
        return conn;
    }

    /**
     * 关闭数据库连接方法
     * @param conn Connection
     * @param ps PreparedStatement
     * @param rs ResultSet
     */
    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs){
        try{
            if (rs != null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("关闭ResultSet失败！");
        }
        try {
            if (ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("关闭PreparedStatement失败!");
        }
        try{
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("关闭Connetion失败！");
        }
    }

    /**
     * 获取数据库数据方法
     * @return
     */
    public static ResultSet getResultSet(){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String querySql = "select KEYWORDS1 from TMALL_TAOBAO_KEYWORDS_ALL";

        try{
            conn = OracleUtil.getConnection();
            if (conn == null){
                System.out.println("获取连接失败");
            }
            statement = conn.prepareStatement(querySql);
            rs = statement.executeQuery();
            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }finally {

            OracleUtil.closeConnection(conn,statement,rs);
            return rs;
        }
    }

    /**
     * 更新数据库方法
     * @param data
     * @return
     */
    public static int updateBatchData(List<KeyWords2Base64> data){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String updateSql = "update  TMALL_TAOBAO_KEYWORDS_ALL set KEYWORDS2=? where  KEYWORDS1=?";
        try{
            conn = OracleUtil.getConnection();
            if (conn == null){
                System.out.println("获取连接失败");
            }

            conn.setAutoCommit(false);
            statement = conn.prepareStatement(updateSql);

            for (KeyWords2Base64 subdata: data){
                statement.setString(1,subdata.getKeyword2());
                statement.setString(2,subdata.getKeyword1());
                statement.addBatch();
            }
//            return 1;
            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(1);
            return -1;
        }finally {
            OracleUtil.closeConnection(conn,statement,rs);
            System.out.println(2);
            return -2;
        }

    }

}

