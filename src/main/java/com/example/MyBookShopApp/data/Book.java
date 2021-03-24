package com.example.MyBookShopApp.data;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date pubDate;
    @Column(columnDefinition = "smallint", nullable = false)
    private Integer isBestseller;
    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    private String title;
    private String image;
    @Column(columnDefinition = "text")
    private String description;
    @Column(nullable = false)
    private Integer price;
    @Column(columnDefinition = "smallint default 0", nullable = false)
    private Integer discount;
    private String priceOld;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookToAuthor> bookToAuthors;

/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookReview> bookReviews;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookToUser> bookToUsers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BalanceTransaction> balanceTransactions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<FileDownload> fileDownloads;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookRating> bookRatings;
*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public List<BookToAuthor> getBookToAuthors() {
        return bookToAuthors;
    }

    public void setBookToAuthors(List<BookToAuthor> bookToAuthors) {
        this.bookToAuthors = bookToAuthors;
    }

/*
    public List<BookReview> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(List<BookReview> bookReviews) {
        this.bookReviews = bookReviews;
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

    public List<BookRating> getBookRatings() {
        return bookRatings;
    }

    public void setBookRatings(List<BookRating> bookRatings) {
        this.bookRatings = bookRatings;
    }
*/
}
