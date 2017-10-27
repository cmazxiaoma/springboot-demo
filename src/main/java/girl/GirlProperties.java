package girl;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@ConfigurationProperties(prefix = "girl")
@Component
public class GirlProperties {
    private String cupSize;
    private String height;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
