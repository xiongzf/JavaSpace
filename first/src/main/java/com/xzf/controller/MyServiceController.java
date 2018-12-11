package com.xzf.controller;

import com.xzf.domain.TVSeriesDto;
import com.xzf.service.TVSeriesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.util.*;

@RestController
@RequestMapping("/first")
public class MyServiceController {
    private static final Log log = LogFactory.getLog(MyServiceController.class);

    @Autowired
    TVSeriesService tvSeriesService;

    @GetMapping
    public List<TVSeriesDto> getAll() {
        if (log.isTraceEnabled()) {
            log.trace("getAll() 被调用了");
        }

        List<TVSeriesDto> list = tvSeriesService.getAllTVSeries();

        if (log.isTraceEnabled()) {
            log.trace("查询获得" + list.size() + "条记录");
        }

        return list;
    }


    @GetMapping("/findAll")
    public List<TVSeriesDto> findAll() {
        List<TVSeriesDto> list = new ArrayList<>();

        if (log.isTraceEnabled()) {
            log.trace(
                    "getAll() 被调用了"
            );
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        list.add(new TVSeriesDto(1, "WestWorld", "1", calendar.getTime()));
        calendar.set(2018, Calendar.SEPTEMBER, 2, 0, 0);
        list.add(new TVSeriesDto(2, "Person of Interest", "5", calendar.getTime()));

        return list;
    }

    @GetMapping("/{id}")
    public TVSeriesDto findById(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne: " + id);
        }

        if (id == 100) {
            return  createPoi();
        } else if (id == 101) {
            return createWW();
        } else {
            throw new ResourceNotFoundException();
        }
    }


    private TVSeriesDto createPoi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, Calendar.SEPTEMBER, 2, 0, 0);
        return new TVSeriesDto(2, "Person of Interest", "5", calendar.getTime());
    }

    private TVSeriesDto createWW() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        return new TVSeriesDto(1, "WestWorld", "1", calendar.getTime());
    }

    @GetMapping("/map")
    public Map<String, Object> sayHello() {
        Map<String, Object> map = new HashMap<>();
        map.put("messge", "hello world");
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteOne(@PathVariable int id, HttpServletRequest request, @RequestParam(value = "delete_version", required = false) String deleteReason) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("deleteOne: " + id);
        }

        Map<String, String> map = new HashMap<>();

        if (id == 100) {
            map.put("message", "#100被" + request.getRemoteAddr() + "删除(原因" + deleteReason + ")");
        } else if (id == 101) {
            throw new RuntimeException("#101不能被删除");
        } else {
            throw new ResourceNotFoundException();
        }

        return map;
    }

    @PostMapping(value = "/{id}/photos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam("photo")MultipartFile imgFile) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("接收到文件 " + id + " 收到文件: " + imgFile.getOriginalFilename());
        }

        FileOutputStream fos = new FileOutputStream("target/" + imgFile.getOriginalFilename());
        IOUtils.copy(imgFile.getInputStream(), fos);
        fos.close();
    }

    // @Valid 如果不添加, bean 里的注解就没用
    @PostMapping
    public TVSeriesDto insertOne(@Valid @RequestBody TVSeriesDto tvSeriesDto) {
        if (log.isTraceEnabled()) {
            log.trace("传递来的参数: " + tvSeriesDto);
        }

        tvSeriesDto.setId(9999);
        return tvSeriesDto;
    }
}































