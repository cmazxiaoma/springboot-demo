package girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
     * @param name
     * @param cupSize
     * @param age
     * @return girl added
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("name") String name, @RequestParam("cupsize") String cupSize
            , @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
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
}
