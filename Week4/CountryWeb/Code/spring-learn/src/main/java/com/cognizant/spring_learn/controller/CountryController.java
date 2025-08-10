package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("deprecation")
@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("country.xml"));
        return (Country) factory.getBean("in");
    }
}
