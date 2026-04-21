package org.github.dabson10.gamevault.repository;

import org.github.dabson10.gamevault.entity.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
    Desarrollador findByNombre(String nombre);
}
