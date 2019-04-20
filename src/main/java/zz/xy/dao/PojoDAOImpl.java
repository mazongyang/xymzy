package zz.xy.dao;

import zz.xy.dao.sql.BuildSql;
import zz.xy.factory.ConnectionFactory;
import zz.xy.pojo.AbstractPojo;
import zz.xy.util.WordCase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * jdbc
 */
public class PojoDAOImpl implements PojoDAO {
    private PreparedStatement preparedStatement = null ;
    @Override
    public boolean pojoInsert(Class<?> clazz,AbstractPojo o) {
        Map<Integer,Object> map = new HashMap<>() ;
        Boolean res = null ;
        try {
            preparedStatement = ConnectionFactory.getPreparedStatement(BuildSql.getInsertSql(clazz,o,map)) ;
            map.forEach((key,value) -> {
                    String typeName = WordCase.toUpperFirst(value.getClass().getSimpleName());
                    try {
                        switch (typeName) {
                            case "Integer":
                                preparedStatement.setInt(++key, (Integer) value);
                                break;
                            case "String":
                                preparedStatement.setString(++key, value.toString());
                                break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            });
            if(preparedStatement.executeUpdate() != '0'){
                res = Boolean.TRUE  ;
            }else{
                res = Boolean.FALSE ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionFactory.closeConnection();
        }
        return res;
    }

}
