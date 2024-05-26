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

@Entity(name="item_class")
@Table(name = "item_class", schema = "inventory")
public class DBItemClass implements Serializable {

    /** Primary key. */
    protected static final String PK = "uid";

    @Id
    @Column(unique=true, nullable=false, precision=10)
    private int uid;
    @ManyToOne
    @JoinColumn(name="classname")
    private DBClass dbClass;
    @ManyToOne(optional=false)
    @JoinColumn(name="itemid", nullable=false)
    private DBItem dbItem;

    /** Default constructor. */
    public DBItemClass() {
        super();
    }

    /**
     * Access method for uid.
     *
     * @return the current value of uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * Setter method for uid.
     *
     * @param aUid the new value for uid
     */
    public void setUid(int aUid) {
        uid = aUid;
    }

    /**
     * Access method for dbClass.
     *
     * @return the current value of dbClass
     */
    public DBClass getDbClass() {
        return dbClass;
    }

    /**
     * Setter method for dbClass.
     *
     * @param aDbClass the new value for dbClass
     */
    public void setDbClass(DBClass aDbClass) {
        dbClass = aDbClass;
    }

    /**
     * Access method for dbItem.
     *
     * @return the current value of dbItem
     */
    public DBItem getDbItem() {
        return dbItem;
    }

    /**
     * Setter method for dbItem.
     *
     * @param aDbItem the new value for dbItem
     */
    public void setDbItem(DBItem aDbItem) {
        dbItem = aDbItem;
    }

    /**
     * Compares the key for this instance with another DBItemClass.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBItemClass and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBItemClass)) {
            return false;
        }
        DBItemClass that = (DBItemClass) other;
        if (this.getUid() != that.getUid()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBItemClass.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBItemClass)) return false;
        return this.equalKeys(other) && ((DBItemClass)other).equalKeys(this);
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
        i = getUid();
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
        StringBuffer sb = new StringBuffer("[DBItemClass |");
        sb.append(" uid=").append(getUid());
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
        ret.put("uid", Integer.valueOf(getUid()));
        return ret;
    }

}
