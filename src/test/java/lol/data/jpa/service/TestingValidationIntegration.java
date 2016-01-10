package lol.data.jpa.service;

import lol.data.jpa.CityValidated;
import lol.data.jpa.SampleDataRestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolationException;

@SpringApplicationConfiguration(classes = SampleDataRestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestingValidationIntegration {

    @Autowired
    CityService cityService;

    @Test(expected = ConstraintViolationException.class)
    public void testValidation() {
        CityValidated pojo = new CityValidated();
        pojo.setName("Brisbane");
        cityService.createNewCity(pojo);
    }


}
