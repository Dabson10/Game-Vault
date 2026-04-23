package org.github.dabson10.gamevault.repository;

import org.github.dabson10.gamevault.entity.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    Videojuego findByNombre(String nombre);
}
