// Generated with g9.

package com.vkr.inventory.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="user_roles")
@Table(name="user_roles", schema = "inventory")
public class DBUserRoles implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @ManyToOne
    @JoinColumn(name="rolename")
    private DBRoles dbRoles;
    @ManyToOne
    @JoinColumn(name="username")
    private DBUsers dbUsers;

    /** Default constructor. */
    public DBUserRoles() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for dbRoles.
     *
     * @return the current value of dbRoles
     */
    public DBRoles getDbRoles() {
        return dbRoles;
    }
    public String getDbRolesNames() {
        return dbRoles.getRolename();
    }
    /**
     * Setter method for dbRoles.
     *
     * @param aDbRoles the new value for dbRoles
     */
    public void setDbRoles(DBRoles aDbRoles) {
        dbRoles = aDbRoles;
    }

    /**
     * Access method for dbUsers.
     *
     * @return the current value of dbUsers
     */
    public DBUsers getDbUsers() {
        return dbUsers;
    }

    /**
     * Setter method for dbUsers.
     *
     * @param aDbUsers the new value for dbUsers
     */
    public void setDbUsers(DBUsers aDbUsers) {
        dbUsers = aDbUsers;
    }

    /**
     * Compares the key for this instance with another DBUserRoles.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBUserRoles and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBUserRoles)) {
            return false;
        }
        DBUserRoles that = (DBUserRoles) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBUserRoles.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBUserRoles)) return false;
        return this.equalKeys(other) && ((DBUserRoles)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[DBUserRoles |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
