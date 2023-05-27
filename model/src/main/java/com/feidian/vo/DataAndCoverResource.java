package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAndCoverResource {

    private InputStreamResource dataResource;

    private InputStreamResource coverResource;

}
