package girl.model;

import com.google.gson.Gson;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Min(value = 18, message = "Minor girls are prohibited from entering")
    private Integer age;

    private String cupSize;

    private Integer hash;

    public Girl(String name, Integer age, String cupSize) {
        this.name = name;
        this.age = age;
        this.cupSize = cupSize;
        this.hash = this.hashCode();
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Girl girl = (Girl) o;

        if (!id.equals(girl.id)) return false;
        if (!name.equals(girl.name)) return false;
        if (!age.equals(girl.age)) return false;
        if (!cupSize.equals(girl.cupSize)) return false;
        return hash.equals(girl.hash);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + cupSize.hashCode();
        return result;
    }
}
