// Generated with g9.

package com.vkr.inventory.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkr.inventory.repository.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Entity(name="item")
@Table(name = "item", schema = "inventory")
@Getter
@Setter
public class DBItem implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";
    
    @Id
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    private String status;
    @Column(name="rfid")
    private String rfidId;
    @Column(nullable=false)
    private String itemname;
    @Column(name="last_location")
    private String lastLocation;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="edited_at")
    private LocalTime editedAt;
    @Column(name="lastseen_at")
    private LocalTime lastseenAt;
    private String metadata;
    @OneToMany(mappedBy="dbItem")
    private Set<DBItemClass> dbItemClass;
    @ManyToOne
    @JoinColumn(name="owner")
    private DBUsers dbUsers;

    public String jvOwner;
    public String getjvOwner() {
		return dbUsers.getUsername();
    	
    }
    public void setjvOwner() {
    	jvOwner= dbUsers.getUsername();
    	
    }
    /** Default constructor. */
    public DBItem() {
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
     * Access method for rfidId.
     *
     * @return the current value of rfidId
     */
    public String getRfidId() {
        return rfidId;
    }

    /**
     * Setter method for rfidId.
     *
     * @param aRfidId the new value for rfidId
     */
    public void setRfidId(String aRfidId) {
        rfidId = aRfidId;
    }

    /**
     * Access method for itemname.
     *
     * @return the current value of itemname
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * Setter method for itemname.
     *
     * @param aItemname the new value for itemname
     */
    public void setItemname(String aItemname) {
        itemname = aItemname;
    }

    /**
     * Access method for lastLocation.
     *
     * @return the current value of lastLocation
     */
    public String getLastLocation() {
        return lastLocation;
    }

    /**
     * Setter method for lastLocation.
     *
     * @param aLastLocation the new value for lastLocation
     */
    public void setLastLocation(String aLastLocation) {
        lastLocation = aLastLocation;
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
    public LocalTime getEditedAt() {
        return editedAt;
    }

    /**
     * Setter method for editedAt.
     *
     * @param aEditedAt the new value for editedAt
     */
    public void setEditedAt(LocalTime aEditedAt) {
        editedAt = aEditedAt;
    }

    /**
     * Access method for lastseenAt.
     *
     * @return the current value of lastseenAt
     */
    public LocalTime getLastseenAt() {
        return lastseenAt;
    }

    /**
     * Setter method for lastseenAt.
     *
     * @param aLastseenAt the new value for lastseenAt
     */
    public void setLastseenAt(LocalTime aLastseenAt) {
        lastseenAt = aLastseenAt;
    }

    /**
     * Access method for metadata.
     *
     * @return the current value of metadata
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * Setter method for metadata.
     *
     * @param aMetadata the new value for metadata
     */
    public void setMetadata(String aMetadata) {
        metadata = aMetadata;
    }

    /**
     * Access method for dbItemClass.
     *
     * @return the current value of dbItemClass
     */
    public Set<DBItemClass> getDbItemClass() {
        return dbItemClass;
    }

    /**
     * Setter method for dbItemClass.
     *
     * @param aDbItemClass the new value for dbItemClass
     */
    public void setDbItemClass(Set<DBItemClass> aDbItemClass) {
        dbItemClass = aDbItemClass;
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
     * Compares the key for this instance with another DBItem.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBItem and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBItem)) {
            return false;
        }
        DBItem that = (DBItem) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBItem.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBItem)) return false;
        return this.equalKeys(other) && ((DBItem)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[DBItem |");
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
