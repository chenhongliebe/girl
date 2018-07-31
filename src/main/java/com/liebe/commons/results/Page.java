package com.liebe.commons.results;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public class Page<T> implements Serializable {

    private int pages;//页数

    private long total;//总记录数

    private int currentPage;//当前页

    private List<T> data;

    public Page(){

    }

    public Page(long total, int pages, int currentPage){
        this.pages = pages;
        this.total = total;
        this.currentPage = currentPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
