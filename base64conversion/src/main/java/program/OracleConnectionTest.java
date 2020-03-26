package program;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OracleConnectionTest
 * @Author zhangqx02
 * @Date 2020/3/26 8:50
 * @Description
 * Base64加密测试执行类
 */

public class OracleConnectionTest {

    private static Connection conn =null;
    private static PreparedStatement statement = null;
    private static ResultSet rs = null;

    public static void main(String[] args) {
        String querySql = "select KEYWORDS1 from TMALL_TAOBAO_KEYWORDS_ALL";

        try{
            conn = OracleUtil.getConnection();
            if (conn == null){
                System.out.println("获取连接失败");
            }
            statement = conn.prepareStatement(querySql);
            rs = statement.executeQuery();
            List<KeyWords2Base64> list = new ArrayList<>();
            while (rs.next()) {
                String keyword1 = rs.getString("KEYWORDS1");
                String keyword2 = Base64Util.encode(keyword1);
                if (keyword1 != null && keyword2 != null) {
                    KeyWords2Base64 newObject = new KeyWords2Base64();
                    newObject.setKeyword1(keyword1);
                    newObject.setKeyword2(keyword2);
                    list.add(newObject);
                    System.out.println(newObject.toString());
                }
            }
            int resultType = OracleUtil.updateBatchData(list);
            System.out.println(resultType);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            OracleUtil.closeConnection(conn,statement,rs);
        }
    }

}
