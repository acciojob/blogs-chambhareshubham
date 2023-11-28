package com.driver.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {
    public Blog() {
    }

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
          private   int bologId;
          private  String title;
           private String content;
          private Date publishDate;
          @OneToMany (mappedBy = "blog")
          List<Image> image;
          @ManyToOne
          User user;

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Blog(int bologId, String title, String content, Date publishDate) {
        this.bologId = bologId;
        this.title = title;
        this.content = content;
        this.publishDate=publishDate;
    }

    public int getBologId() {
        return bologId;
    }

    public void setBologId(int bologId) {
        this.bologId = bologId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}