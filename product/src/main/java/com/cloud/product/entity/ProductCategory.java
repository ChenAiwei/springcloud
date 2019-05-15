package com.cloud.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/14 15:41
 */
@Data
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue()
	private Integer categoryId;

	/** 类目名字. */
	private String categoryName;

	/** 类目编号. */
	private Integer categoryType;

	private Date createTime;

	private Date updateTime;
}
