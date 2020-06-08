package com.m1nist3r.dormitory.web.application.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PaginatedUtil {

    public static <T> void setPages(Page<T> page, Model model) {
        int totalPages = page.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }

    public static <T> Page<T> getPaginationList(Pageable pageable, List<T> tList) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<T> list;

        if (tList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, tList.size());
            list = tList.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), tList.size());
    }
}
