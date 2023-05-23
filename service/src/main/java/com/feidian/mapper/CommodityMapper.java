package com.feidian.mapper;

import com.feidian.domain.Commodity;
import com.feidian.vo.CommodityVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityMapper {
    void insertCommodity(CommodityVo commodityVo);

    void updateCommodityDescription(String description);

    List<Commodity> findByUserId(long id);

    Commodity findByCommodityId(long id);
}
