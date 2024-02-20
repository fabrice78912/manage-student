package com.school.service;

import com.school.model.Etudiant;
import org.example.common.dto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EtudiantService {

    public Etudiant inscrireEtudiant(Etudiant etudiant);
    public List<Etudiant> getAllEtudiants();
    public ResponseDto getAllEtudiants(Pageable pageable);

    //public Page<Etudiant> getAllEtudiants(Pageable pageable);
}
