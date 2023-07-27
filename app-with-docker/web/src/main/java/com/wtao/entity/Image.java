package com.wtao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2023-06-13
 */
@Getter
@Setter
@ApiModel(value = "Image对象", description = "")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer osType;
    private String originName;
    private String fileType;
    private String note;
    private Date createTime;
    private String stage;
    private Integer enable;
    private String status;
    private String task;
    private Date taskStartTime;
    private String cloudId;
    private String diskFormat;
    private Long size;
    private Integer virtualSize;
}
