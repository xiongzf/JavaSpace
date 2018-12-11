package com.xzf.first;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xzf.domain.TVSeriesDto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class TVBean {
    @Null
    private Integer id;

    @NotNull
    private String name;

    @DecimalMin("1")
    private int seasonCount;

//    @Valid 表示要级联校验; @Size(min = 2)表示这个列表至少要有2项内容,否则通不过校验
    @Valid @NotNull @Size(min = 2)
    private List<TVSeriesDto> tvCharacters;

//    如果想用 long 型的 timestamp 表示日期,可用 @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//    @Past 表示只接受过去的时间,比当前时间还晚的被认为不合格
    @Past
    private Date originRelease;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public List<TVSeriesDto> getTvCharacters() {
        return tvCharacters;
    }

    public void setTvCharacters(List<TVSeriesDto> tvCharacters) {
        this.tvCharacters = tvCharacters;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }
}
