package cn.xiaoshan.VO;

import lombok.Data;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/13 13:14
 * @Description : Http请求返回的最外层对象
 **/
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
