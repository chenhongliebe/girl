/**
 * 
 * **
 * 
 * Dict.java
 * 
 */
package com.liebe.sys.entity;

import java.util.Date;

/**
 * <p>
 * 表 : dict的 Model 类
 * 
 * @author 	sft
 * @date 	2018年08月07日
 */
public class Dict {
    /** 字段:id，主键 */
    private Integer id;

    /** 字段:value，数据值 */
    private String value;

    /** 字段:label，标签名 */
    private String label;

    /** 字段:type，类型 */
    private String type;

    /** 字段:sort，排序（升序 */
    private Long sort;

    /** 字段:description，描述 */
    private String description;

    /** 字段:create_id，创建者 */
    private Integer createId;

    /** 字段:create_date，创建时间 */
    private Date createDate;

    /** 字段:update_id，更新者 */
    private Integer updateId;

    /** 字段:update_date，更新时间 */
    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}