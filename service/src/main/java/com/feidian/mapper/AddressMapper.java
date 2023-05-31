package com.feidian.mapper;

import com.feidian.po.AddressPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressMapper {
    AddressPO findByAddressId(long addressId);
}
