package com.leosanqing.leetcode.medium.array;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 任务实体
 * @author zdsys-008
 */
@Getter
@Setter
public class TaskEvData implements Serializable {
    /**
     * 任务状态码:0[过程中]>>1[成功]>>2[失败]
     */
    private int status;
    /**
     * 任务状态解读:[运行中]>>[运行成功]>>[运行失败]
     */
    private String statusMsg;
    /**
     * 状态成功时,对应的cosurl
     */
    private String url;
    /**
     * 截图成功时,对应的存证hash
     */
    private String hash;
}
