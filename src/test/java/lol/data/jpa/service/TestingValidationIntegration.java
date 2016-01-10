package lol.data.jpa.service;

import lol.data.jpa.BeanValidator;
import lol.data.jpa.CityPojo;
import lol.data.jpa.SampleDataRestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringApplicationConfiguration(classes = SampleDataRestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestingValidationIntegration {

    @Autowired
    CityService cityService;

    @Test
    public void testValidation() {

        CityPojo pojo = new CityPojo();
        pojo.setName("Baia Mare");

        cityService.createNewCity(pojo);


    }


}
