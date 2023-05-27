package com.feidian.mapper;

import com.feidian.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AddressMapper {
    Address findByAddressId(long addressId);
}
