package com.feidian.controller;

import com.feidian.domain.Cart;
import com.feidian.domain.Commodity;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/getCartVoList")
    public ResponseResult getCartVoList(@RequestBody long userId) {
        List<Cart> list = getCartList(userId);
        List<CartVo> cartVoList = new ArrayList<>();

        for (Cart cart : list) {

            Commodity commodity = commodityService.findByCommodityId(cart.getCommodityId());
            BigDecimal totalPrice = commodity.getPrice().multiply(cart.getCommodityNum());

            CartVo cartVo = new CartVo(cart.getId(), cart.getUserId(), cart.getCommodityId(),
                    cart.getAddressId(), commodity.getCommodityDescription(), commodity.getPrice(),
                    cart.getCommodityNum(), totalPrice, cart.getOrderStatus(),
                    cart.getUpdateTime(), cart.getIsDeleted());
            cartVoList.add(cartVo);
        }

        return new ResponseResult(200, "操作成功", cartVoList);
    }

    public List<Cart> getCartList(long userId){
        return cartService.findByUserId(userId);
    }

}
