package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
public class VendorOrderItem extends AbstractEntity {
	
	private BigDecimal quantity;

	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn(name="vendor_order_id")
	VendorOrder vendorOrder;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	Article article;

}
