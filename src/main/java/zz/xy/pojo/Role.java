package zz.xy.pojo;

import java.util.Objects;

public class Role extends AbstractPojo{
    private Integer roleid ;
    private String rolename ;
    private String remark ;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getRoleid(), role.getRoleid()) &&
                Objects.equals(getRolename(), role.getRolename()) &&
                Objects.equals(getRemark(), role.getRemark());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRoleid(), getRolename(), getRemark());
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
