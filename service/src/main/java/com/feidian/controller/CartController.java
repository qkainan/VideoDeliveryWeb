package com.feidian.controller;

import com.feidian.domain.Address;
import com.feidian.domain.Cart;
import com.feidian.domain.Commodity;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.JwtUtil;
import com.feidian.vo.CartVo;
import com.feidian.vo.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private OrderService orderService;

    @PostMapping("/postCart")
    public ResponseResult postCart(CartVo cartVo){
        cartService.insertCart(cartVo.getId(), cartVo.getUserId(), cartVo.getCommodityId(), cartVo.getAddressId(),
                cartVo.getCommodityDescription(), cartVo.getPrice(), cartVo.getCommodityNum(), cartVo.getTotalPrice(),
                cartVo.getOrderStatus());
        return new ResponseResult(200,"操作成功");
    }

    @GetMapping("/getCartVoList")
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

    @PutMapping("/putCatStatus")
    public ResponseResult putCatStatus(@RequestBody Cart cart){
        cartService.updateOrderStatus(cart.getId(),cart.getOrderStatus());
        return new ResponseResult(200,"更新成功");
    }

    @PostMapping("/postCartPurchase")
    public ResponseResult postCartPurchase(PurchaseVo purchaseVo) {
        long userId = JwtUtil.getUserId();

        //状态（5：已收货 4：代发货 3：已发货 2：代发货 0：已退款 ）
        long orderStatus = 1;
        Commodity commodity = commodityService.findByCommodityId(purchaseVo.getCommodityId());
        Address address = userService.findByAddressId(purchaseVo.getAddressId());

        orderService.insertOrder(purchaseVo.getId(), userId, commodity.getUserId(), address.getAddressName(),
                commodity.getCommodityAddress(), orderStatus);
        return new ResponseResult(200,"操作成功");
    }

    @PostMapping("/postTakeCommodity")
    public ResponseResult postTakeCommodity(long orderId){
        orderService.updateStatus(orderId);
        return new ResponseResult(200,"操作成功");
    }

    public List<Cart> getCartList(long userId){
        return cartService.findByUserId(userId);
    }

}
