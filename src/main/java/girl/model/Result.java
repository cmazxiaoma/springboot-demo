package girl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String msg;
    private Object data;
}
