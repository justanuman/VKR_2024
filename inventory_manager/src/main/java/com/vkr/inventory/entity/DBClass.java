// Generated with g9.

package com.vkr.inventory.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;


@Entity(name="class")
@Table(name = "class", schema = "inventory")
public class DBClass implements Serializable {

    /** Primary key. */
    protected static final String PK = "classname";

    @Id
    @Column(unique=true, nullable=false)
    private String classname;
    @Column(precision=10)
    private int amount;
    @Column(precision=17, scale=17)
    private double price;
    private String metadata;
    @OneToMany(mappedBy="dbClass")
    private Set<DBItemClass> dbItemClass;

    /** Default constructor. */
    public DBClass() {
        super();
    }

    /**
     * Access method for classname.
     *
     * @return the current value of classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * Setter method for classname.
     *
     * @param aClassname the new value for classname
     */
    public void setClassname(String aClassname) {
        classname = aClassname;
    }

    /**
     * Access method for amount.
     *
     * @return the current value of amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    public void setAmount(int aAmount) {
        amount = aAmount;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(double aPrice) {
        price = aPrice;
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
     * Compares the key for this instance with another DBClass.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DBClass and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DBClass)) {
            return false;
        }
        DBClass that = (DBClass) other;
        Object myClassname = this.getClassname();
        Object yourClassname = that.getClassname();
        if (myClassname==null ? yourClassname!=null : !myClassname.equals(yourClassname)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DBClass.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DBClass)) return false;
        return this.equalKeys(other) && ((DBClass)other).equalKeys(this);
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
        if (getClassname() == null) {
            i = 0;
        } else {
            i = getClassname().hashCode();
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
        StringBuffer sb = new StringBuffer("[DBClass |");
        sb.append(" classname=").append(getClassname());
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
        ret.put("classname", getClassname());
        return ret;
    }

}
