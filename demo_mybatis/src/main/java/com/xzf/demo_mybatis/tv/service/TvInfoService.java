package com.xzf.demo_mybatis.tv.service;

import com.xzf.demo_mybatis.tv.dao.TvInfoDao;
import com.xzf.demo_mybatis.tv.model.TvInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author commafit
 * @date 2018/12/19 7:21 PM
 */
@Service
public class TvInfoService {
    @Resource
    private TvInfoDao infoDao;

    public int insert(TvInfo info) {
        return infoDao.insert(info);
    }
}
