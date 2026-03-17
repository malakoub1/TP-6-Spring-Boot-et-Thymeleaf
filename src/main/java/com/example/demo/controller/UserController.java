package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    // Injection du repository par constructeur
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Afficher la liste de tous les utilisateurs
    @GetMapping
    public String displayUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/new")
    public String displayCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    // Enregistrer un nouvel utilisateur
    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {

        // Si la validation échoue, on revient au formulaire
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        return "redirect:/users";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String displayEditForm(@PathVariable Long id, Model model) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable avec l'id : " + id));

        model.addAttribute("user", existingUser);
        return "update-user";
    }

    // Mettre à jour un utilisateur existant
    @PostMapping("/update/{id}")
    public String updateExistingUser(@PathVariable Long id,
                                     @Valid @ModelAttribute("user") User user,
                                     BindingResult result) {

        // En cas d'erreur de validation, on garde l'id et on retourne au formulaire
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        user.setId(id);
        userRepository.save(user);
        return "redirect:/users";
    }

    // Supprimer un utilisateur
    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable Long id) {
        User userToDelete = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable avec l'id : " + id));

        userRepository.delete(userToDelete);
        return "redirect:/users";
    }
}