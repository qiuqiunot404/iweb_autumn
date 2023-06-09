package com.iweb.test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Guan
 * @date 2023/6/8 10:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private int id;
    private String receive;
    private String response;
}
