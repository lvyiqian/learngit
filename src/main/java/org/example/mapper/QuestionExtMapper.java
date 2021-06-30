package org.example.mapper;

import org.example.dto.QuestionQueryDTO;
import org.example.model.Question;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question record);

    int incCommentCount(Question record);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectSticky();

    List<Question> selectRelated(Question question);

}
