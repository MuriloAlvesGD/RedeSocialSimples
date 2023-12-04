package br.edu.unifacisa.RedeSocialSimples.repository;

import br.edu.unifacisa.RedeSocialSimples.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
