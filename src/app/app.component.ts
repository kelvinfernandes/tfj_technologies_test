import { Component, OnInit } from '@angular/core';
import { Utilisateur } from './utilisateur';
import { UtilisateurService } from './utilisateur.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public utilisateurs: Utilisateur[];
  public editUtilisateur: Utilisateur;
  public deleteUtilisateur: Utilisateur;

  constructor(private utilisateurService: UtilisateurService){}

  ngOnInit() {
    this.getUtilisateurs();
  }

  public getUtilisateurs(): void {
    this.utilisateurService.getUtilisateurs().subscribe(
      (response: Utilisateur[]) => {
        this.utilisateurs = response;
        console.log(this.utilisateurs);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddUtilisateur(addForm: NgForm): void {
    document.getElementById('add-utilisateur-form').click();
    this.utilisateurService.addUtilisateur(addForm.value).subscribe(
      (response: Utilisateur) => {
        console.log(response);
        this.getUtilisateurs();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateUtilisateur(utilisateur: Utilisateur): void {
    this.utilisateurService.updateUtilisateur(utilisateur).subscribe(
      (response: Utilisateur) => {
        console.log(response);
        this.getUtilisateurs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteUtilisateur(utilisateurId: number): void {
    this.utilisateurService.deleteUtilisateur(utilisateurId).subscribe(
      (response: void) => {
        console.log(response);
        this.getUtilisateurs();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchUtilisateurs(key: string): void {
    console.log(key);
    const results: Utilisateur[] = [];
    for (const utilisateur of this.utilisateurs) {
      if (utilisateur.nom.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || utilisateur.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || utilisateur.numero.toLowerCase().indexOf(key.toLowerCase()) !== -1
      || utilisateur.emploi.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(utilisateur);
      }
    }
    this.utilisateurs = results;
    if (results.length === 0 || !key) {
      this.getUtilisateurs();
    }
  }

  public onOpenModal(utilisateur: Utilisateur, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addUtilisateurModal');
    }
    if (mode === 'edit') {
      this.editUtilisateur = utilisateur;
      button.setAttribute('data-target', '#updateUtilisateurModal');
    }
    if (mode === 'delete') {
      this.deleteUtilisateur = utilisateur;
      button.setAttribute('data-target', '#deleteUtilisateurModal');
    }
    container.appendChild(button);
    button.click();
  }



}
