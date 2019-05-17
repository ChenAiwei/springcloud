package com.cloud.product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/14 15:59
 */
@Data
@Entity
public class ProductInfo implements Serializable {
	@Id
	private String productId;
	private String productName;
	private BigDecimal productPrice;
	private Integer productStock;
	private String productDescription;
	private String productIcon;
	private Integer productStatus;
	private Integer categoryType;
	private Date createTime;
	private Date updateTime;
}
