# Application De Gestion Des Utilisateurs 

#Installation:


#####################################################################
####POUR LE FRONT-END:

=>Prérequis:
-Vous devez avoir la version 14.17.6 ( ou version supérieure ) de Node.js.

-Dans le repertoire du projet, vous devez installer les modules de node néessaires pour le focntionnement de l'application.
Pour le faire utilisez la commande : "npm install"

-Vous devez avoir la version 9.1.5 ( ou version supérieure ) de angular. 
Pour installer utilisez la commande npm install -g @angular/cli.

-vous devez avoir Visual Studio Code Version 2017 ( ou supérieure ) pour lancer le programme frontend.
Vous pouvez télécharger sur ce lien:
https://code.visualstudio.com/

-Vous devez avoir un système de gestion de base de données Mysql version 5.7.11 ( ou supérieure ).
Vous pouvez télécharger sur ce lien:
https://www.mysql.com/fr/downloads/



##Lancement De L'Application:

-Dans le terminal de visual studio tapez "ng serve".
Avant cela, vous devez installer node, les modules de l'application "gestion des utilisateurs" et angular.


###################################################################
#POUR LE BACK-END:

=>Prérequis:
-Vous devez avoir le framework spring boot version 4.13.1 RELEASE (ou supérieure ) pour le coté back-end.
Voici le lien pour télécharger le framework spring boot  : https://spring.io/projects/spring-boot



#######Lancer le programme Back-end:
vous devez avoir le framework spring boot.
-Sur spring boot, vous devez cofigurer l'accées à votre base de données via le fichier "application" qui se trouve dans "src/main/resources".
Vous devez configurer de la maniere suivante:

# MySQL Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_des_utilisateurs?serverTimezone=CET
spring.datasource.username= Votre login
spring.datasource.password= Votre mot de passe
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

Une fois que ce fichier est configuré, allez dans l'onglet "project" de spring boot framework, puis cliquez sur "clean".
Ensuite, cliquez sur le nom du dossier à savoir, gestion_des_utilisateurs_backend, contenant le projet, faites clique droit et selectionnez Run As.
Puis selectionnez Spring Boot App.

=> En suivant ces étapes l'application back-end va se lancer et la base de données sera crée avec les colonnes de manière automatique.
Le nom des colonnes est lié au fichier "Utilisateur.java". Ce fichier, est dans "com.tfj.gestionsdesutilisateurs.model".


##ROUTES:
Une fois que le backend est lancé, l'API REST est accessible sur le port par défaut de spring boot. C'est le port 8080.
Vous pouvez faire "localhost:8080" sur votre navigateur et vous pouvez lancer manuellement l'appel aux differentes routes.
les routes sont: 
"/utilisateur": c'est la route de base
"/tous": recupere tous les utilisateurs
"/find{id}": recupere un utilisateur selon son id
"/ajout": ajoute un utilisateur
"/modification": modifie un utilisateur
"/suppression/{id}": supprime un utilisateur selon son id



########Interface
Vous pouvez tester l'application back avec des jeux de données via postman. 
ou via une interface  Thymeleaf de Spring Boot. 

Mais, cette application "gestion des utilisateurs"  possède sa propre interface. 
C'est une interface HTML et Angular, permettant de créer, supprimer et modifier un utilisateur.

Pour supprimer vous devez cliquer sur le bouton "x", pour modifier vous devez cliquer sur le bouton en forme de crayon.
Pour ajouter un nouveau utilisateur vous devez cliquer sur le bouton rouge "ajouter un utilisateur".


Avant de lancer l'application en front end vous devez lancer l'application en back end via spring boot. 
sinon vous aurez une erreur lorsque vous essayez d'ajouter un utilisateur :
"Http failure response for http://localhost:8080/utilisateur/tous: 0 Unknown Error".Voici le lien: 

Pour résoudre ce problème, lancez l'application back-end avec Spring Boot. 

###Pour lancer le serveur angular, et donc pour lancer l'interface tapez "ng serve" sur visual studio dans le répertoire racine de l'application.

