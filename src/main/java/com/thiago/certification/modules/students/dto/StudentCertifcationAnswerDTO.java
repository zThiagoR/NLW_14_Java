package com.thiago.certification.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCertifcationAnswerDTO {

    private String email;
    private String technology;

    private List<QuestionAnswerDTO> questionsAnswers;
}
