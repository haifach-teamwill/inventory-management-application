package com.chagwey.springbootinventorymanagement.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClientOrderItem extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "client_order_id")
    @JsonIgnoreProperties({"clientOrderItems"})
    private ClientOrder clientOrder;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @JsonIgnoreProperties({"clientOrderItems"})
    private Article article;

    private BigDecimal quantity;

    private BigDecimal unitPrice;


}
