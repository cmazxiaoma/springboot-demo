package girl.handler;

import girl.enums.ResultCode;
import girl.exception.GirlException;
import girl.model.Result;
import girl.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
@ControllerAdvice
public class ExceptionHandler {
    private static final Logger _log = LoggerFactory.getLogger(ExceptionHandler.class);


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e) {
        if (e instanceof GirlException) {
            return ResultGenerator.error(((GirlException) e).getResultCode());
        } else {
            _log.error("unknow exception = {}", e.getMessage());
            return ResultGenerator.error(ResultCode.UNKNOW_ERROR);
        }
    }
}
