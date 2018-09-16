package com.upgrad.ImageHoster.model;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {

    // These annotations auto-increments the id column for us whenever
    // a new Comments is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String comment;

    public Comment() {

    }

    public Comment(String comment) {
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Image getImage() {
        return image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
