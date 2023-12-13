package br.edu.unifacisa.RedeSocialSimples.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table (name = "TB_Posts")
public class Postagem {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column (name = "post_ID", nullable = false)
    private Integer postID;

    @Column (name = "post_content", nullable = false)
    private String content;

    @Column (name = "post_date", nullable = false)
    private LocalDateTime postDate;

    @ManyToOne
    @JoinColumn(name = "user_post_id")
    private Usuario author;

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public Usuario getAuthor() {
        return author;
    }

    public void setAuthor(Usuario author) {
        this.author = author;
    }

}