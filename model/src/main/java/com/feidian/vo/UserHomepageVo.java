package com.feidian.vo;

import com.feidian.domain.Cart;
import com.feidian.domain.Commodity;
import com.feidian.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
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

    private List<BuyerOrderVo> buyerOrderVoList;

    private List<SellerOrderVo> sellerOrderVoList;

    private List<Cart> cartList;

}
