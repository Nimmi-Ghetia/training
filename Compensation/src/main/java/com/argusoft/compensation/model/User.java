package com.argusoft.compensation.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
//import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

//@Embeddable
@Entity(name = "user1")
//@Table(name = "user2")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = true, columnDefinition = "varchar(255) default 'Hello'")
    private String username;
    private String password;
    private String active;
    private String lastname;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
//    @Column(columnDefinition = "bit(1) default 1")
//    private boolean checked;
//    @Column(columnDefinition = "bigint(19,2) default 100")
    private BigDecimal salary;
//    @Column(columnDefinition = "int default 100")

    private int x;
//    @ElementCollection
//    private List<Role_> roles=new ArrayList<>() ;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "city", column = @Column(name = "Residential_City"))
        ,
                @AttributeOverride(name = "state", column = @Column(name = "Residential_State"))
    })
    private Address address;
    
    @Embedded
     @AttributeOverrides({
        @AttributeOverride(name = "city", column = @Column(name = "office_City"))
        ,
                @AttributeOverride(name = "state", column = @Column(name = "office_State"))
    })
    private Address officeaddress;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", active=" + active + ", lastname=" + lastname + ", dob=" + dob + ", salary=" + salary + ", x=" + x + ", address=" + address + '}';
    }

    


    

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }

}
