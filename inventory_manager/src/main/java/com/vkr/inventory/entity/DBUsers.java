// Generated with g9.

package com.vkr.inventory.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity(name="users")
@Table(name="users", schema = "inventory")
@Transactional
public class DBUsers implements Serializable {

    /** Primary key. */
    protected static final String PK = "username";

    @Id
    @Column(unique=true, nullable=false)
    private String username;
    private String mail;
    @Column(nullable=false)
    public String password;
    private String status;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy="dbUsers",fetch = FetchType.EAGER)
    private Set<DBUserRoles> dbUserRoles;
    @OneToMany(mappedBy="dbUsers")
    private Set<DBItem> dbItem;

    /** Default constructor. */
    public DBUsers() {
        super();
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for mail.
     *
     * @return the current value of mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Setter method for mail.
     *
     * @param aMail the new value for mail
     */
    public void setMail(String aMail) {
        mail = aMail;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
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
     * Access method for updatedAt.
     *
     * @return the current value of updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter method for updatedAt.
     *
     * @param aUpdatedAt the new value for updatedAt
     */
    public void setUpdatedAt(LocalDateTime aUpdatedAt) {
        updatedAt = aUpdatedAt;
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
     * Access method for dbItem.
     *
     * @return the current value of dbItem
     */
    public Set<DBItem> getDbItem() {
        return dbItem;
    }

    /**
     * Setter method for dbItem.
     *
     * @param aDbItem the new value for dbItem
     */
    public void setDbItem(Set<DBItem> aDbItem) {
        dbItem = aDbItem;
    }

    /**
     * Compares the key for this instance with another DBUsers.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBUsers and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBUsers)) {
            return false;
        }
        DBUsers that = (DBUsers) other;
        Object myUsername = this.getUsername();
        Object yourUsername = that.getUsername();
        if (myUsername==null ? yourUsername!=null : !myUsername.equals(yourUsername)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBUsers.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBUsers)) return false;
        return this.equalKeys(other) && ((DBUsers)other).equalKeys(this);
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
        if (getUsername() == null) {
            i = 0;
        } else {
            i = getUsername().hashCode();
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
        StringBuffer sb = new StringBuffer("[DBUsers |");
        sb.append(" username=").append(getUsername());
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
        ret.put("username", getUsername());
        return ret;
    }

}
