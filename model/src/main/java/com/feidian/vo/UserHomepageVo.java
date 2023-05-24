package com.feidian.vo;

import com.feidian.domain.Cart;
import com.feidian.domain.Commodity;
import com.feidian.domain.SaleOrder;
import com.feidian.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHomepageVo {
    private long id;
    private String username;
    private String userDescription;
    private Integer phone;
    private String headUrl;
    private String emailAddress;

    private List<Video> videoList;

    private List<Commodity> commodityList;

    private List<SaleOrder> orderList;

    private List<Cart> cartList;

}
