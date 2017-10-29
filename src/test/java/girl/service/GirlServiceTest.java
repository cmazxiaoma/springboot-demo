package girl.service;

import girl.handler.ExceptionHandler;
import girl.model.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by cmazxiaoma on 2017/10/29.
 * everyday is mayday.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() throws Exception {
        Girl girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(15), girl.getAge());
    }

}