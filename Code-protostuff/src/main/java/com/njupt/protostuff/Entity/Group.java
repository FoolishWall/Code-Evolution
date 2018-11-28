package com.njupt.protostuff.Entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author wall
 * @date 2018/11/27  21:54
 * @description
 */
@Data
@Builder
public class Group {
    private String id;

    private String name;

    private User user;
}
