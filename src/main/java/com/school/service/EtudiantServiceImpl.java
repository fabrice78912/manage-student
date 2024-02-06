package com.school.service;

import com.school.model.Etudiant;
import com.school.repo.EtudiantRepo;
import com.school.validation.EtudiantValidation;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.example.common.exception.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepo etudiantRepository;

    @Override
    public Etudiant inscrireEtudiant(Etudiant etudiant) {
        //validate data etudiant
        validateEtudiant(etudiant);

        Optional<Etudiant> etudiantOptional = etudiantRepository.findByAdresseEmail(etudiant.getAdresseEmail());

        if (!etudiantOptional.isPresent()) { // check if etudiant not exist

            // Generate matricule by checking if it's already exist and set it to etudiant
            String matriculeNumber;
            do {
                matriculeNumber = generateMatricule();
            } while (etudiantRepository.existsByMatriculeEtudiant(matriculeNumber));

            //set etudiant matricule
            etudiant.setMatriculeEtudiant(matriculeNumber);
            return etudiantRepository.save(etudiant);

        } else {
            throw new ValidationException("Etudiant already exits");
        }


    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Page<Etudiant> getAllEtudiants(Pageable pageable) {
        return etudiantRepository.findAll(pageable);
    }

    public Optional<Etudiant> getEtudiantById(Long etudiantId) {
        return etudiantRepository.findById(etudiantId);
    }


    private void validateEtudiant(Etudiant etudiant) {
        try {
            EtudiantValidation.validate(etudiant);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation failed for Etudiant data", e);
        }
    }


    public static String generateMatricule() {
        String matPrefix = "MAT - ";
        String dateOfDay = getCurrentDate();
        String randomAlphabets = generateRandomAlphabets(5);

        return matPrefix + dateOfDay + " " + randomAlphabets;
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }


    private static String generateRandomAlphabets(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

    public Page<Etudiant> getAllEtudiants(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return etudiantRepository.findAll(pageable);
    }


}

