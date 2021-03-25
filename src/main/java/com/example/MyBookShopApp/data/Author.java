package com.example.MyBookShopApp.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
@ApiModel(description = "data model of author enrity")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "author id generated by db",position = 1)
    private Integer id;
    private String photo;
    @Column(nullable = false)
    private String slug;
    @Column(nullable = false)
    @ApiModelProperty(value = "name of author",example = "Bob Blaskovits", position = 2)
    private String name;
    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private List<BookToAuthor> bookToAuthors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookToAuthor> getBookToAuthors() {
        return bookToAuthors;
    }

    public void setBookToAuthors(List<BookToAuthor> bookToAuthors) {
        this.bookToAuthors = bookToAuthors;
    }
}
