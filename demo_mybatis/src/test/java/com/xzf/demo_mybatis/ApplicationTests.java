package com.xzf.demo_mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzf.demo_mybatis.tv.dao.TvInfoDao;
import com.xzf.demo_mybatis.tv.model.TvInfo;
import com.xzf.demo_mybatis.tv.service.TvInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Resource
	private TvInfoService tvInfoService;

	@Resource
	private TvInfoDao infoDao;

	@Test
	public void contextLoads() {
		TvInfo info = new TvInfo();
		info.setActor("张三");
		info.setContent("哦哦哦");
		info.setTag("热血");

		int result = tvInfoService.insert(info);
		System.out.println(result);
	}

	@Test
	public void insert() {
		TvInfo info = new TvInfo();
		info.setActor("张三");
		info.setContent("哦哦哦");
		info.setTag("热血");

		Assert.assertTrue(infoDao.insert(info) > 0);
		System.err.println("\n插入成功 ID 为：" + info.getId());
	}

	@Test
	public void select() {
		Assert.assertEquals("李四", infoDao.selectById(1L).getActor());
		TvInfo info = infoDao.selectOne(new QueryWrapper<TvInfo>().lambda().eq(TvInfo::getId, 2));
		Assert.assertEquals("热血", info.getTag());
		Assert.assertEquals("哦哦哦", info.getContent());
	}

	@Test
	public void delete() {
		Assert.assertTrue(infoDao.deleteById(3L) > 0);
		Assert.assertTrue(infoDao.delete(new QueryWrapper<TvInfo>().lambda().eq(TvInfo::getId, 5)) > 0);
	}

	@Test
	public void update() {
		Assert.assertTrue(infoDao.updateById(new TvInfo().setId(2).setContent("你大爷的腿儿")) > 0);
		Assert.assertTrue(infoDao.update(new TvInfo().setActor("王五"),
				new UpdateWrapper<TvInfo>().lambda().set(TvInfo::getTag, "暴力").eq(TvInfo::getId,
						4)) > 0);
	}

}

