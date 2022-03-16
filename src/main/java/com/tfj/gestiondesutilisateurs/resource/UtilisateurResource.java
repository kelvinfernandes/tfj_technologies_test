package com.tfj.gestiondesutilisateurs.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tfj.gestiondesutilisateurs.model.Utilisateur;
import com.tfj.gestiondesutilisateurs.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurResource {
    private final UtilisateurService utilisateurService;

    public UtilisateurResource(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/tous")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs () {
        List<Utilisateur> utilisateurs = utilisateurService.findAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById (@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.findUtilisateurById(id);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }

    @PostMapping("/ajout")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur newUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
    }

    @PutMapping("/modification")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur updateUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
    }

    @DeleteMapping("/suppression/{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id) {
        utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
