package druip;


import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectTableReference;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleASTVisitorAdapter;
import com.alibaba.druid.util.JdbcConstants;
import org.apache.derby.iapi.reference.SQLState;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OracleVisitor
 * @Author zhangqx02
 * @Date 2019/9/25 9:04
 * @Description
 */

public class OracleVisitor {
    public static void main(String[] args){
        final String dbType = JdbcConstants.ORACLE;
        String sql = "select * from mytable a where a.id = 3";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql,dbType);

        ExportTableAliasVisitor visitor = new ExportTableAliasVisitor();
        for (SQLStatement stmt :stmtList){
            stmt.accept(visitor);
        }
        SQLTableSource tableSource = visitor.getAliasMap().get("a");
        System.out.println(tableSource);
    }
}
class ExportTableAliasVisitor extends OracleASTVisitorAdapter {
    private Map<String, SQLTableSource> aliasMap = new HashMap<String, SQLTableSource>();
    public boolean visit(OracleSelectTableReference x) {
        String alias = x.getAlias();
        aliasMap.put(alias, x);
        return true;
    }

    public Map<String, SQLTableSource> getAliasMap() {
        return aliasMap;
    }
}
