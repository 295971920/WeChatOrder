package cn.xiaoshan.exception;

import cn.xiaoshan.enums.ResultEnum;

/**
 * @Author : XIAOSHAN
 * @Contact_QQ : 295971920
 * @CreateDate : 2020/9/18 6:18
 * @Description :
 **/
public class SellException extends RuntimeException {

    private Integer code;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMassage());
        this.code = resultEnum.getCode();
    }
}
