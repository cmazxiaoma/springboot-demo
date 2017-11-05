package girl.service;

import girl.enums.ResultCode;
import girl.exception.GirlException;
import girl.repository.GirlRepository;
import girl.model.Girl;
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
        Girl girlA = new Girl("garrett-test-1", 18, "Z");
        girlRepository.save(girlA);

        Girl girlB = new Girl("mayday-test-1", 21, "ABCDEFG");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws GirlException {
        Girl girl = girlRepository.findOne(id);
        int age = girl.getAge();

        if (age > 0 && age < 18) {
            throw new GirlException(ResultCode.LOLITA);
        } else if (age >= 18 && age < 30) {
            throw new GirlException(ResultCode.ROYAL_SISTER);
        } else if (age >= 30 && age < 35) {
            throw new GirlException(ResultCode.YOUNG_WOMAN);
        } else {
            throw new GirlException(ResultCode.AUNT);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
