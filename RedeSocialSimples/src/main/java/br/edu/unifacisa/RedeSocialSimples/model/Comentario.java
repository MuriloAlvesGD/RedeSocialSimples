package br.edu.unifacisa.RedeSocialSimples.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.LinkedList;

@Entity
@Table
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_ID", nullable = false)
    private Integer comentID;

    @Column (name = "comment_Content", nullable = false)
    private String content;

    @Column (name = "comment_likes")
    private Integer likes;

    private LinkedList<Comentario> answers;

    @ManyToOne
    @JoinColumn (name = "user_comment_id")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "post_comment_id")
    private Postagem post;
}

