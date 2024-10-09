package com.thiago.certification.modules.certifications.controllers;

import com.thiago.certification.modules.certifications.useCases.Top10RankingUseCase;
import com.thiago.certification.modules.students.entities.CertificationsStudentEntity;
import com.thiago.certification.modules.students.repositories.CertificationStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private Top10RankingUseCase top10RankingUseCase;



    @GetMapping("/top10")
    public List<CertificationsStudentEntity> Top10() {
        return this.top10RankingUseCase.execute();
    }
}
