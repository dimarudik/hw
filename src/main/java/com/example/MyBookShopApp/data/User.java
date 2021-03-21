package com.example.MyBookShopApp.data;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String hash;
    @Column(nullable = false)
    private Timestamp regTime;
    @Column(columnDefinition = "int default 0", nullable = false)
    private Integer balance;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookReview> bookReviews;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookReviewLike> bookReviewLikes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<UserContact> userContacts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookToUser> bookToUsers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BalanceTransaction> balanceTransactions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<FileDownload> fileDownloads;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Message> messages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(List<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
    }

    public List<BookReviewLike> getBookReviewLikes() {
        return bookReviewLikes;
    }

    public void setBookReviewLikes(List<BookReviewLike> bookReviewLikes) {
        this.bookReviewLikes = bookReviewLikes;
    }

    public List<UserContact> getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(List<UserContact> userContacts) {
        this.userContacts = userContacts;
    }

    public List<BookToUser> getBookToUsers() {
        return bookToUsers;
    }

    public void setBookToUsers(List<BookToUser> bookToUsers) {
        this.bookToUsers = bookToUsers;
    }

    public List<BalanceTransaction> getBalanceTransactions() {
        return balanceTransactions;
    }

    public void setBalanceTransactions(List<BalanceTransaction> balanceTransactions) {
        this.balanceTransactions = balanceTransactions;
    }

    public List<FileDownload> getFileDownloads() {
        return fileDownloads;
    }

    public void setFileDownloads(List<FileDownload> fileDownloads) {
        this.fileDownloads = fileDownloads;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
