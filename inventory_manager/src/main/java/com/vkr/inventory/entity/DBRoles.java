// Generated with g9.

package com.vkr.inventory.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="roles")
@Table(name = "roles", schema = "inventory")
public class DBRoles implements Serializable {

    /** Primary key. */
    protected static final String PK = "rolename";

    @Id
    @Column(unique=true, nullable=false)
    private String rolename;
    private String status;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="edited_at")
    private LocalDateTime editedAt;
    @OneToMany(mappedBy="dbRoles")
    private Set<DBUserRoles> dbUserRoles;

    /** Default constructor. */
    public DBRoles() {
        super();
    }

    /**
     * Access method for rolename.
     *
     * @return the current value of rolename
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * Setter method for rolename.
     *
     * @param aRolename the new value for rolename
     */
    public void setRolename(String aRolename) {
        rolename = aRolename;
    }

    /**
     * Access method for status.
     *
     * @return the current value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(String aStatus) {
        status = aStatus;
    }

    /**
     * Access method for createdAt.
     *
     * @return the current value of createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter method for createdAt.
     *
     * @param aCreatedAt the new value for createdAt
     */
    public void setCreatedAt(LocalDateTime aCreatedAt) {
        createdAt = aCreatedAt;
    }

    /**
     * Access method for editedAt.
     *
     * @return the current value of editedAt
     */
    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    /**
     * Setter method for editedAt.
     *
     * @param aEditedAt the new value for editedAt
     */
    public void setEditedAt(LocalDateTime aEditedAt) {
        editedAt = aEditedAt;
    }

    /**
     * Access method for dbUserRoles.
     *
     * @return the current value of dbUserRoles
     */
    public Set<DBUserRoles> getDbUserRoles() {
        return dbUserRoles;
    }

    /**
     * Setter method for dbUserRoles.
     *
     * @param aDbUserRoles the new value for dbUserRoles
     */
    public void setDbUserRoles(Set<DBUserRoles> aDbUserRoles) {
        dbUserRoles = aDbUserRoles;
    }

    /**
     * Compares the key for this instance with another DBRoles.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBRoles and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBRoles)) {
            return false;
        }
        DBRoles that = (DBRoles) other;
        Object myRolename = this.getRolename();
        Object yourRolename = that.getRolename();
        if (myRolename==null ? yourRolename!=null : !myRolename.equals(yourRolename)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBRoles.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBRoles)) return false;
        return this.equalKeys(other) && ((DBRoles)other).equalKeys(this);
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
        if (getRolename() == null) {
            i = 0;
        } else {
            i = getRolename().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[DBRoles |");
        sb.append(" rolename=").append(getRolename());
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
        ret.put("rolename", getRolename());
        return ret;
    }

}
