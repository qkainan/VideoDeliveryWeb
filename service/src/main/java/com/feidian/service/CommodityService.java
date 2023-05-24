package com.feidian.service;

import com.feidian.domain.Commodity;


import java.util.List;

public interface CommodityService {

    void insertCommodity(Commodity commodity);

    void updateCommodityDescription(String description);

    List<Commodity> findByUserId(long id);

    Commodity findByCommodityId(long id);
}
