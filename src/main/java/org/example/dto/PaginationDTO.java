package org.example.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class PaginationDTO<T> {

    private List<T> data;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer Page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;
    public void setPagination(Integer totalPage, Integer page)
    {
        this.totalPage = totalPage;
        this.Page = page;
        //根据当前page确定展示的数组List<Integer> pages
        pages.add(page);
        for(int i = 1; i <= 3; i++)
        {
            if(page - i > 0)
            {
                pages.add(0,page-i);
            }
            if(page + i <= totalPage)
            {
                pages.add(page + i);
            }
        }
        //是否展示<
        if(page == 1) {
            showPrevious = false;
        } else{
            showPrevious  = true;
        }
        //是否展示>
        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }
        //是否展示<<
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否展示>>
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }
    }
}
