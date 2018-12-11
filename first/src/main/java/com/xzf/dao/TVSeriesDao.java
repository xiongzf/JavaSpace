package com.xzf.dao;

import com.xzf.domain.TVSeriesDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TVSeriesDao {

    @Select("select * from tv_series")
    public List<TVSeriesDto> getAll();
}
