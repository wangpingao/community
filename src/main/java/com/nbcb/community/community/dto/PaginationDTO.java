package com.nbcb.community.community.dto;

import com.nbcb.community.community.model.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangpingao
 * @Date: 2019/9/29
 * @Description: com.nbcb.community.community.dto
 * @Version: 1.0
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questionDTOList;
    private Boolean showPrevious;
    private Boolean showFirst;
    private Boolean showNext;
    private Boolean showLast;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;


        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }
        if (page == 1) {
            this.showPrevious = false;
        } else {
            this.showPrevious = true;
        }
        if (page == this.totalPage) {
            this.showNext = false;
        } else {
            this.showNext = true;
        }
        if (this.pages.contains(1)) {
            this.showFirst = false;
        } else {
            this.showFirst = true;
        }
        if (this.pages.contains(this.totalPage)) {
            this.showLast = false;
        } else {
            this.showLast = true;
        }

    }
}
