package com.thiago.certification.modules.certifications.useCases;

import com.thiago.certification.modules.students.entities.CertificationsStudentEntity;
import com.thiago.certification.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Top10RankingUseCase {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public List<CertificationsStudentEntity> execute() {
        return this.certificationStudentRepository.findTop10ByOrderByCreatedAtDesc();
    }
}
