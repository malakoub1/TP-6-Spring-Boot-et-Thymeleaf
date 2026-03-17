# 📋 Gestion des Utilisateurs - Spring Boot MVC

## 📌 Description
Ce projet est une petite application web développée avec **Spring Boot** qui permet de gérer des utilisateurs.  
L'application implémente les opérations **CRUD** (Create, Read, Update, Delete) avec une architecture MVC.

Les utilisateurs peuvent :
- Ajouter un utilisateur
- Consulter la liste des utilisateurs
- Modifier un utilisateur
- Supprimer un utilisateur

---

## 🏗 Architecture du projet

L'application suit l'architecture **MVC (Model - View - Controller)** :

- **Model (Domaine)**  
  Contient l'entité `User` représentant les données de l'utilisateur.

- **Repository**  
  Utilise **Spring Data JPA** pour accéder à la base de données.

- **Controller**  
  Gère les requêtes HTTP et la logique entre les vues et la base de données.

- **View**  
  Utilise **Thymeleaf** pour afficher les pages HTML.

---

## 🛠 Technologies utilisées

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Thymeleaf
- HTML / CSS
- Maven

---

## ✨ Fonctionnalités

- Création d'un utilisateur
- Affichage de la liste des utilisateurs
- Modification des informations d'un utilisateur
- Suppression d'un utilisateur
- Validation des champs avec **Hibernate Validator**

---

## 📂 Video DEMO

https://github.com/user-attachments/assets/3e63b5c1-c61c-4acd-8f12-f90faa8b884c
