package com.xzf.domain;

import java.util.List;

/**
 * 这是一个用于封装了分页的数据.
 * 里面包含
 * 该页的学生数据集合
 * 总的记录数
 * 总的页数
 * 当前页
 * 每页显示的记录数
 *
 * @author commafit
 */
public class PageBean<T> {
    private int currentPage;
    private int totalPage;
    private int pageSize;
    private int totalSize;
    private List<T> list;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
