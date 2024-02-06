package com.school.controller;

import com.school.model.Etudiant;
import com.school.service.EtudiantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.common.exception.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @PostMapping("/inscrire")
    public ResponseEntity<Etudiant> inscrireEtudiant(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.inscrireEtudiant(etudiant), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return new ResponseEntity<>(etudiantService.getAllEtudiants(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Etudiant>> getAllEtudiants(
            @Valid @RequestParam(defaultValue = "0") Integer page,
            @Valid @RequestParam(defaultValue = "5") Integer size) {

        // Validate page and size
        if (page < 0 || size <= 0) {
            throw new ValidationException("Page and size must be greater than or equal to 0");
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<Etudiant> etudiants = etudiantService.getAllEtudiants(pageable);
        return ResponseEntity.ok(etudiants);
    }
}
