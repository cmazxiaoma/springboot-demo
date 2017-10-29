package girl.enums;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
public enum  ResultCode {
    UNKNOW_ERROR(-1, "unknow error"),
    SUCCESS(0, "success"),
    UNAUTHORIZED(401, "no authorized"),
    NOT_FOUND(404, "not found"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    LOLITA(1, "lolita"),
    ROYAL_SISTER(2, "royal sister"),
    YOUNG_WOMAN(3, "young woman"),
    AUNT(4, "aunt");


    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
