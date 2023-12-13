package br.edu.unifacisa.RedeSocialSimples.repository;

import br.edu.unifacisa.RedeSocialSimples.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Usuario findFirstUsuarioByEmailAndPassword (String USER_EMAIL, String USER_PASSWORD);

    Usuario findUsuariosByUserID (Integer userID);

    Usuario findFirstUsuarioByUserName (String userName);

    @Query (value = "SELECT DISTINCT TB_USERS.* FROM TB_USERS WHERE TB_USERS.USER_ID not like :userID",nativeQuery = true)
    List<Usuario> findUsuariosSuggestions (Integer userID);
}
