package org.github.dabson10.gamevault.repository;

import org.github.dabson10.gamevault.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenerosRepository extends JpaRepository<Genero, Long> {
    Genero findByGenero(String genero);
    List<Genero> findByGeneroIn(List<String> generos);
}
