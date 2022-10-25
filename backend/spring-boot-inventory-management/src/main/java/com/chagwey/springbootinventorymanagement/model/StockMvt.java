package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;
import java.time.Instant;
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
public class StockMvt extends AbstractEntity{
	
	private Instant mvtDate;
	
	private BigDecimal quantity;
	
//	private StockMvtType stockMvtType;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	Article article;
	

}
