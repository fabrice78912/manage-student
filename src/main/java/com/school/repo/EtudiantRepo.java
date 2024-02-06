package com.school.repo;

import com.school.model.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

    boolean existsByMatriculeEtudiant(String matriculeNumber);
    Optional<Etudiant> findByAdresseEmail(String adresseEmail);
    Page<Etudiant> findAll(Pageable pageable);
}
