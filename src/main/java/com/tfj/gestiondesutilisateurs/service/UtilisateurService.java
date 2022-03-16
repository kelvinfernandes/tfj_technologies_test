package com.tfj.gestiondesutilisateurs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfj.gestiondesutilisateurs.exception.UserNotFoundException;
import com.tfj.gestiondesutilisateurs.model.Utilisateur;
import com.tfj.gestiondesutilisateurs.repo.UtilisateurRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UtilisateurService {
    private final UtilisateurRepo utilisateurRepo;

    @Autowired
    public UtilisateurService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
    	utilisateur.setUtlisateurCode(UUID.randomUUID().toString());
        return utilisateurRepo.save(utilisateur);
    }

    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepo.findUtilisateurById(id)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur avec id " + id + " n'a pas été trouvé"));
    }

    public void deleteUtilisateur(Long id){
        utilisateurRepo.deleteUtilisateurById(id);
    }
}
