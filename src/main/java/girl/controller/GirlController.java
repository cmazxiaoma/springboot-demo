package girl.controller;

import girl.enums.ResultCode;
import girl.exception.GirlException;
import girl.model.Result;
import girl.repository.GirlRepository;
import girl.service.GirlService;
import girl.model.Girl;
import girl.utils.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by cmazxiaoma on 2017/10/27.
 * everyday is mayday.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private static final Logger log = LoggerFactory.getLogger(GirlController.class);

    /**
     * Queries all girls.
     * @return girls List queryed
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }


    /**
     * Adds girl
     * @param girl
     * @return girl added
     */
    @PostMapping(value = "/girls")
    public Result girlAdd(@Valid  Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        int hash = girl.hashCode();
        girl.setHash(hash);
        log.info("hash=" + hash);

        Girl repeatGirl = girlRepository.findByHash(hash);

        if (repeatGirl != null) {
            return ResultGenerator.error(ResultCode.REPEATABLE_DATA);
        }

        girlRepository.save(girl);
        return ResultGenerator.success();
    }

    /**
     * Finds girl by id
     * @param id
     * @return girl finded
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    /**
     * Updates girl
     * @param id
     * @param name
     * @param cupSize
     * @param age
     * @return girl updated
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdateOne(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("cupsize") String cupSize
            , @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setName(name);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * Deletes girl by id
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDeleteOne(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * Queries girls by name
     * @param name
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/name/{name}")
    public List<Girl> girlFindByName(@PathVariable("name") String name) {
        return girlRepository.findByName(name);
    }

    /**
     * Queries girls by age
     * @param age
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * Queries girls by cupsize
     * @param cupSize
     * @return girl list queryed
     */
    @GetMapping(value = "/girls/cupsize/{cupsize}")
    public List<Girl> girlFindByCupSize(@PathVariable("cupsize") String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    /**
     * Tests transaction
     */
    @GetMapping(value = "/transaction")
    public void transactionTest() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getAge(id);
    }
}
