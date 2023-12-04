package br.edu.unifacisa.RedeSocialSimples.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Set;

@Entity
@Table
public class Postagem {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column (name = "post_ID", nullable = false)
    private Integer postID;

    @Column (name = "post_content", nullable = false)
    private String content;

    @Column (name = "post_date", nullable = false)
    private Date postDate;

    @Column (name = "post_likes")
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "user_post_id")
    private Usuario author;

    @OneToMany(mappedBy = "post")
    private LinkedList<Comentario> ccomments;
}