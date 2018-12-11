package com.xzf.service;

import com.xzf.dao.TVSeriesDao;
import com.xzf.domain.TVSeriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TVSeriesService {

    @Autowired
    TVSeriesDao tvSeriesDao;
    public List<TVSeriesDto> getAllTVSeries() {
        return tvSeriesDao.getAll();
    }
}
