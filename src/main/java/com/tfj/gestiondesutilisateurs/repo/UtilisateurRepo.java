package com.tfj.gestiondesutilisateurs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfj.gestiondesutilisateurs.model.Utilisateur;

import java.util.Optional;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
    void deleteUtilisateurById(Long id);

    Optional<Utilisateur> findUtilisateurById(Long id);
}
