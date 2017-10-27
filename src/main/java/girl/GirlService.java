package girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl("garrett-test", 18, "Z");
        girlRepository.save(girlA);

        Girl girlB = new Girl("mayday-test", 21, "BBBBBBBB");
        girlRepository.save(girlB);
    }
}
