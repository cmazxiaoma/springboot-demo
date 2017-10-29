package girl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 18, message = "Minor girls are prohibited from entering")
    private Integer age;

    private String cupSize;


    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                '}';
    }
}
