package com.feidian.service;

import com.feidian.domain.Commodity;
import com.feidian.vo.CommodityVo;

import java.util.List;

public interface CommodityService {

    void updateCommodityDescription(String description);

    void releaseCommodity(CommodityVo commodityVo);

    List<Commodity> findByUserId(long id);

    Commodity findByCommodityId(long id);
}
