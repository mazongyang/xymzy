package zz.xy.dao;

import zz.xy.pojo.AbstractPojo;

public interface PojoDAO {
    boolean pojoInsert(Class<?> clazz,AbstractPojo o) ;
}
