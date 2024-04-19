package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ResponseDTO<T> {
    private int status;
    private long totalElements;
    private T content;

    public ResponseDTO(int status, T content){
        this.status = status;
        this.content = content;
    }

    public ResponseDTO(long totalElements, T content){
        this.totalElements = totalElements;
        this.content = content;
    }
}
