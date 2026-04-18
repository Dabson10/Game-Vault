package org.github.dabson10.gamevault.repository;

import org.github.dabson10.gamevault.entity.Coleccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColeccionRepository extends JpaRepository<Coleccion, Long> {
}
