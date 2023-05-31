package com.feidian.controller;

import com.feidian.po.AddressPO;
import com.feidian.po.CartPO;
import com.feidian.po.CommodityPO;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.JwtUtil;
import com.feidian.vo.CartVO;
import com.feidian.vo.PurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    @PostMapping("/postCart")
    public ResponseResult postCart(@RequestBody CartVO cartVo){
        CommodityPO commodityPO = commodityService.findByCommodityId(cartVo.getCommodityId());
        long orderStatus = 0;
        //@CurrentUserId long userId = 0;
        BigDecimal totalPrice = commodityPO.getPrice().multiply(cartVo.getCommodityNum());
        cartVo = new CartVO(0,cartVo.getUserId(), cartVo.getCommodityId(),
                cartVo.getAddressId(), commodityPO.getCommodityDescription(),
                commodityPO.getPrice(), cartVo.getCommodityNum(), totalPrice,
                orderStatus);
        cartService.insertCart(cartVo.getUserId(), cartVo.getCommodityId(),
                cartVo.getAddressId(), commodityPO.getCommodityDescription(),
                commodityPO.getPrice(), cartVo.getCommodityNum(), totalPrice,
                orderStatus);
         return new ResponseResult(200,"操作成功",cartVo);
    }
    @Transactional
    @GetMapping("/getCartVoList")
    public ResponseResult getCartVoList(@RequestBody long userId) {
        List<CartPO> list = getCartList(userId);
        List<CartVO> cartVOList = new ArrayList<>();

        for (CartPO cart : list) {

            CommodityPO commodityPO = commodityService.findByCommodityId(cart.getCommodityId());
            BigDecimal totalPrice = commodityPO.getPrice().multiply(cart.getCommodityNum());

            CartVO cartVo = new CartVO(cart.getId(), cart.getUserId(), cart.getCommodityId(),
                    cart.getAddressId(), commodityPO.getCommodityDescription(), commodityPO.getPrice(),
                    cart.getCommodityNum(), totalPrice, cart.getOrderStatus(),
                    cart.getUpdateTime(), cart.getIsDeleted());
            cartVOList.add(cartVo);
        }

        return new ResponseResult(200, "操作成功", cartVOList);
    }
    @Transactional
    @PutMapping("/putCatStatus")
    public ResponseResult putCatStatus(@RequestBody CartPO cart){
        cartService.updateOrderStatus(cart.getId(),cart.getOrderStatus());
        return new ResponseResult(200,"更新成功");
    }
    @Transactional
    @PostMapping("/postCartPurchase")
    public ResponseResult postCartPurchase(PurchaseVO purchaseVo) {
        long userId = JwtUtil.getUserId();

        //状态（5：已收货 4：代发货 3：已发货 2：代发货 0：已退款 ）
        long orderStatus = 1;
        CommodityPO commodityPO = commodityService.findByCommodityId(purchaseVo.getCommodityId());
        AddressPO address = userService.findByAddressId(purchaseVo.getAddressId());

        orderService.insertOrder(purchaseVo.getId(), userId, commodityPO.getUserId(), address.getAddressName(),
                commodityPO.getCommodityAddress(), orderStatus);
        return new ResponseResult(200,"操作成功");
    }
    @Transactional
    @PostMapping("/postTakeCommodity")
    public ResponseResult postTakeCommodity(long orderId){
        orderService.updateStatus(orderId);
        return new ResponseResult(200,"操作成功");
    }

    public List<CartPO> getCartList(long userId){
        return cartService.findByUserId(userId);
    }

}
