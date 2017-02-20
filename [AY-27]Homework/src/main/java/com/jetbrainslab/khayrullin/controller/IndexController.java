package com.jetbrainslab.khayrullin.controller;

import com.jetbrainslab.khayrullin.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private static List<Person> list = new ArrayList<>();

    @RequestMapping(name = "/index", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String getResultPage(Model model,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("middleName") String middleName,
                                @RequestParam("dateOfBirth") String dateOfBirth,
                                @RequestParam("gender") String gender) {
        Person person = makePerson(firstName, lastName, middleName, dateOfBirth, gender);
        list.add(person);
        model.addAttribute("list", list);
        return "result";
    }

    private Person makePerson(String firstName, String lastName, String middleName, String dateOfBirth, String gender) {
        Person person = new Person();
        if (!firstName.equals("")) person.setFirstName(firstName);
        if (!lastName.equals("")) person.setLastName(lastName);
        if (!middleName.equals("")) person.setMiddleName(middleName);
        if (!dateOfBirth.equals("")) person.setDateOfBirth(dateOfBirth);
        if (!gender.equals("")) person.setGender(gender);
        return person;
    }
}
