package br.edu.unifacisa.RedeSocialSimples.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column (name = "user_ID", nullable = false)
    private Integer userID;

    @Column (name = "user_name", nullable = false)
    private String name;

    @Column (name = "user_userName", nullable = false)
    private String userName;

    @Column (name = "user_password", nullable = false)
    private String password;

    @Column (name = "user_biography")
    private String biography;

    @Column (name = "user_bornDate")
    private Date bornDate;

    @Column (name = "user_email", nullable = false)
    private String email;

    @Column (name = "user_age", nullable = false)
    private Integer age;

    @Column (name = "user_gender")
    private String gender;

    @Column (name = "user_nationality")
    private String nationality;

    @Column (name = "user_cellNumber")
    private Integer CellNumber;


    @ManyToOne
    @JoinColumn (name = "Friends_ID")
    private Usuario userFriend;
    @OneToMany (mappedBy = "userFriend")
    private HashSet<Usuario> usersFriends;


    @OneToMany(mappedBy = "author")
    private LinkedList<Postagem> posts;

    @OneToMany(mappedBy = "user")
    private Set<Comentario> comments;
}
