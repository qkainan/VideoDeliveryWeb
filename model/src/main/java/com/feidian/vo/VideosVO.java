package com.feidian.vo;

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
public class VideosVO {

    private List<VideoPO> videoPOList;

    private List<CommodityPO> commodityPOList;

}
