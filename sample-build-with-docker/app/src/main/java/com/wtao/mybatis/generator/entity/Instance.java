package com.wtao.mybatis.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Instance对象", description = "")
public class Instance implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Long groupId;
    private Long imageId;
    private Long flavorId;
    private Long userId;
    private String note;
    private Date createTime;
    private String stage;
    private Integer enable;
    private Integer status;
    private String task;
    private Date taskStartTime;
    private Integer taskRetry;
    private String cloudId;
    private Long hypervisorId;

    @ApiModelProperty(value = "虚拟机当前事件ID")
    private Long eventId;
}
