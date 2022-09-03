package com.sitech.employee.domain.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    @JsonProperty("response_code")
    public int code;

    @JsonProperty("message")
    public String message;

    @JsonProperty("data")
    T t;
}
