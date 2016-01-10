package lol.data.jpa.service;

import lol.data.jpa.CityValidated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityEndpoint {

    @Autowired
    CityService cityService;

    @RequestMapping(method = RequestMethod.GET, value = "/testing/validation")
    public String testingValidation(@RequestParam String name) {
        CityValidated pojo = new CityValidated();
        pojo.setName(name);
        cityService.createNewCity(pojo);
        return name;
    }

}
