package com.thiago.certification.modules.students.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionAnswerDTO {

    private UUID questionID;
    private UUID alternativeID;

    private boolean isCorrect;
}
