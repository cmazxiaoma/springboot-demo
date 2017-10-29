package girl.utils;

import girl.enums.ResultCode;
import girl.model.Result;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
public class ResultGenerator {

    public static Result success() {
        return success(null);
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result error(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(null);
        return  result;
    }
}
