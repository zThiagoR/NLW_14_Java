package com.thiago.certification.modules.students.useCases;

import com.thiago.certification.modules.students.dto.VerifyIfHasCerticationDTO;
import com.thiago.certification.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyIfHasCerticationDTO dto) {
        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());

        if (!result.isEmpty()) {
            return true;
        }

        return false;
    }

}
