package com.feidian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

    private Integer code;
    private String msg;

    private byte[] fileByte;


    public FileDTO(String msg) {
        this.msg = msg;
    }

    public FileDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
