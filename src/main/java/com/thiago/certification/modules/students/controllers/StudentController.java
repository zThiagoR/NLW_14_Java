package com.thiago.certification.modules.students.controllers;

import com.thiago.certification.modules.students.dto.StudentCertifcationAnswerDTO;
import com.thiago.certification.modules.students.dto.VerifyIfHasCerticationDTO;
import com.thiago.certification.modules.students.useCases.StudentCertificationAnswersCase;
import com.thiago.certification.modules.students.useCases.VerifyIfHasCertificationCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationCase verifyIfHasCertificationUCase;

    @Autowired
    private StudentCertificationAnswersCase studentCertificationAnswersCase;

    @PostMapping("/verify-certification")
    public String verifyIfHasCertification(@RequestBody VerifyIfHasCerticationDTO verifyHasCerticationDTO) {
        var result = this.verifyIfHasCertificationUCase.execute(verifyHasCerticationDTO);

        if (result) {
            return "Usuário possui certificação";
        }

        return "Usuário não possui certificação";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertifcationAnswerDTO studentCertifcationAnswerDTO) {
        try {
            var result = this.studentCertificationAnswersCase.execute(studentCertifcationAnswerDTO);

            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
