package com.example.seata.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author WongChy
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String voucherCode;

    private BigDecimal amount;


}
