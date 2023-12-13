package br.edu.unifacisa.RedeSocialSimples.repository;

import br.edu.unifacisa.RedeSocialSimples.model.Postagem;
import br.edu.unifacisa.RedeSocialSimples.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostagemRepository extends JpaRepository <Postagem, Integer> {

    @Query (value = "SELECT DISTINCT TB_POSTS.* FROM TB_POSTS, TB_USER_FRIENDS WHERE TB_POSTS.USER_POST_ID like TB_USER_FRIENDS.FRIEND_ID and TB_USER_FRIENDS.USER_ID like :userID and TB_POSTS.USER_POST_ID not like :userID ORDER BY POST_DATE desc", nativeQuery = true)
    List<Postagem> findFriendPostsOrderByPostDateDesc(Integer userID);

    @Query (value = "SELECT DISTINCT TB_POSTS.* FROM TB_POSTS WHERE TB_POSTS.USER_POST_ID like :userID ORDER BY POST_DATE desc", nativeQuery = true)
    List<Postagem> findPostsOrderByPostDateDesc(Integer userID);
}

