package com.xzf.demo_mybatis.tv.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzf
 * @since 2018-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TvInfo extends Model<TvInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value="id" , type = IdType.AUTO)
    private Integer id;

    private String content;

    private String tag;

    private String actor;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
