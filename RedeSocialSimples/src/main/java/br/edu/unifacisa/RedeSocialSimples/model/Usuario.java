package br.edu.unifacisa.RedeSocialSimples.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table (name = "TB_Users")
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
    private Integer bornDate;

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

    @ManyToMany
    @JoinTable(name="TB_USER_FRIENDS",
            joinColumns=@JoinColumn(name="USER_ID"),
            inverseJoinColumns=@JoinColumn(name="FRIEND_ID")
    )
    private List<Usuario> usuariosB;

    @ManyToMany
    @JoinTable(name="TB_USER_FRIENDS",
            joinColumns=@JoinColumn(name="FRIEND_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID")
    )
    private List<Usuario> usuariosA;

    @OneToMany(mappedBy = "author")
    private List<Postagem> posts;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getBornDate() {
        return bornDate;
    }

    public void setBornDate(Integer bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getCellNumber() {
        return CellNumber;
    }

    public void setCellNumber(Integer cellNumber) {
        CellNumber = cellNumber;
    }

    public List<Postagem> getPosts() {
        return posts;
    }

    public void setPosts(List<Postagem> posts) {
        this.posts = posts;
    }

    public List<Usuario> getUsuariosA() {
        return usuariosA;
    }

    public void setUsuariosA(List<Usuario> usuariosA) {
        this.usuariosA = usuariosA;
    }

    public List<Usuario> getUsuariosB() {
        return usuariosB;
    }

    public void setUsuariosB(List<Usuario> usuariosB) {
        this.usuariosB = usuariosB;
    }
}
