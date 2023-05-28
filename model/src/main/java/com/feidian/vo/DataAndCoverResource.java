package com.feidian.vo;

import com.feidian.dto.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAndCoverResource {

    private byte[] dataResource;

    private byte[] coverResource;

}
