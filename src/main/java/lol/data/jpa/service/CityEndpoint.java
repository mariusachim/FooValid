package lol.data.jpa.service;

import lol.data.jpa.CityPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityEndpoint {

    @Autowired
    CityService cityService;

    @RequestMapping(method = RequestMethod.GET, value = "/testing/validation")
    public void testingValidation(@RequestParam String name) {
        CityPojo pojo = new CityPojo();
        pojo.setName(name);
        cityService.createNewCity(pojo);
    }

}
