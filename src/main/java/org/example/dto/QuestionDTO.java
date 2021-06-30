package org.example.dto;

import lombok.Data;
import org.example.model.User;


@Data
public class QuestionDTO {

    private Long id;
    private String title;
    private String description;
    private String tag;
    private Integer creator;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
    private Integer sticky;
}
