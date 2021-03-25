package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.config.ContactType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_contact")
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ContactType type;
    private Integer approved;
    private String code;
    private Integer codeTrails;
    private Timestamp codeTime;
    @Column(nullable = false)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCodeTrails() {
        return codeTrails;
    }

    public void setCodeTrails(Integer codeTrails) {
        this.codeTrails = codeTrails;
    }

    public Timestamp getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Timestamp codeTime) {
        this.codeTime = codeTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
