package br.edu.unifacisa.RedeSocialSimples.repository;

import br.edu.unifacisa.RedeSocialSimples.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository <Postagem, Integer> {
}
