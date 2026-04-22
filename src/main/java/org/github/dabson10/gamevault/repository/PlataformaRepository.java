package org.github.dabson10.gamevault.repository;

import org.github.dabson10.gamevault.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository <Plataforma, Long> {
    Plataforma findByNombrePlataforma(String nombrePlataforma);
}
