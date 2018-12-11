package com.xzf.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TVSeriesDto {
    private int id;

    @NotNull
    private String name;
    private String seasonCount;
    private Date originRelease;


    public TVSeriesDto(int id, String name, String seasonCount, Date originRelease) {
        this.id = id;
        this.name = name;
        this.seasonCount = seasonCount;
        this.originRelease = originRelease;
    }

    @Override
    public String toString() {
        return "TVSeriesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasonCount='" + seasonCount + '\'' +
                ", originRelease='" + originRelease + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(String seasonCount) {
        this.seasonCount = seasonCount;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }
}
