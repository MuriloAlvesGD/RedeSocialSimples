package br.edu.unifacisa.RedeSocialSimples.repository;

import br.edu.unifacisa.RedeSocialSimples.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
