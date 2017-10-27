package girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    public List<Girl> findByAge(Integer age);

    public List<Girl> findByCupSize(String cupSize);

    public List<Girl> findByName(String name);
}
