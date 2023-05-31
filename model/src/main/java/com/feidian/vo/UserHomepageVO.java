package com.feidian.vo;

import com.feidian.po.CartPO;
import com.feidian.po.CommodityPO;
import com.feidian.po.VideoPO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHomepageVO {
    private long id;
    private String username;
    private String userDescription;
    private Integer phone;
    private String headUrl;
    private String emailAddress;

    private List<VideoPO> videoPOList;

    private List<CommodityPO> commodityPOList;

    private List<PurchaseOrderVO> buyerOrderVoList;

    private List<SaleOrderVO> sellerOrderVoList;

    private List<CartPO> cartList;

}