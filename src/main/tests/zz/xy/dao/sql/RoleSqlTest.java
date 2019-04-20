package zz.xy.dao.sql;

import org.junit.Test;
import zz.xy.pojo.Role;

import static org.junit.Assert.*;

public class RoleSqlTest {

    @Test
    public void getInsertSql() {
        Role role = new Role() ;
        role.setRoleid(2);
        role.setRolename("马");
        role.setRemark("第二个用户");
//        System.out.println(RoleSql.getInsertSql(role));
    }
}