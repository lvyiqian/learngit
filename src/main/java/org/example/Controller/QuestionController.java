package org.example.Controller;

import org.example.Enum.CommentTypeEnum;
import org.example.Exception.CustomizeErrorCode;
import org.example.Exception.CustomizeException;
import org.example.Service.CommentService;
import org.example.Service.QuestionService;
import org.example.dto.CommentDTO;
import org.example.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    CommentService commentService;

    @GetMapping("/question/{id}")
    public String  question(@PathVariable(name = "id") String id, Model model){
        Long questionId = null;
        try{
            questionId = Long.parseLong(id);
        }catch(NumberFormatException e){
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        QuestionDTO questionDTO = questionService.getById(questionId);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(questionId, CommentTypeEnum.QUESTION);
        questionService.incView(questionId);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
