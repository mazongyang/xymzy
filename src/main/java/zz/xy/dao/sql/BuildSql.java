package zz.xy.dao.sql;

import zz.xy.pojo.AbstractPojo;
import zz.xy.util.WordCase;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * sql构造过程
 */
public class BuildSql{

    public static String getInsertSql(Class<?> type, AbstractPojo vo, Map map){
        String sql = null ;
        String tableName = WordCase.toLowerFirst(type.getSimpleName()) ;
        Field[] fields = type.getDeclaredFields() ;
        StringBuffer bufferStart = new StringBuffer("INSERT INTO " + tableName + " (") ;
        StringBuffer bufferContent = new StringBuffer(") VALUES (") ;
        for (int i = 0 ; i < fields.length ; i ++){
            // 拼前半部分SQL
            bufferStart.append(fields[i].getName()).append(",") ;
            // 拼后半部分SQL，method 数组中 method的顺序是乱取的，所以只能用"get"+字段名的方式完成method调用
            try {
                Method method = type.getDeclaredMethod("get" + WordCase.toUpperFirst(fields[i].getName())) ;
                // 字段个数决定预编译个数
                bufferContent.append("?,") ;
                if (method.getReturnType() == Integer.class){
                    map.put(i,method.invoke(vo)) ;
                        // 使用占位符预编译，取消sql注入
//                    bufferContent.append("TO_NUMBER(").append(method.invoke(vo)).append("),") ;
                } else if (method.getReturnType() == String.class) {
                    map.put(i,method.invoke(vo)) ;
//                    bufferContent.append("'").append(method.invoke(vo)).append("',");
                }
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        bufferStart.deleteCharAt(bufferStart.length() - 1) ;
        bufferContent.deleteCharAt(bufferContent.length() - 1).append(")") ;
        sql = new String(bufferStart.append(bufferContent)) ;
        System.out.println(sql);
        return sql ;
    }

}
