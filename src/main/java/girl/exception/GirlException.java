package girl.exception;

import girl.enums.ResultCode;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
public class GirlException extends RuntimeException {
    private Integer code;
    private ResultCode resultCode;

    public GirlException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
