package zz.xy.dao;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import zz.xy.pojo.Users;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PojoDAOImplTest {

    PojoDAO pojoDAO = new PojoDAOImpl() ;
    @Test
    public void role1Insert() {
//        Role role = new Role() ;
//        role.setRoleid(4);
//        role.setRolename("CFO");
//        role.setRemark("第四个角色");
        Users user = new Users() ;
        user.setUserId(9);
        user.setUserName("");
        user.setUserype(2);
        user.setUserPwd("paaaassword");
//        Assert.assertTrue(roleDAO.pojoInsert(Role.class,role)) ;
        Assert.assertTrue(pojoDAO.pojoInsert(Users.class,user));
    }

}