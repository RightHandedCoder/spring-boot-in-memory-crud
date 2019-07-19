package com.shams.spring.springbootinmemorycrud.controller;

import com.shams.spring.springbootinmemorycrud.model.Contact;
import com.shams.spring.springbootinmemorycrud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/contacts")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "list";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Contact contact) {
        contactService.createNewContact(contact);
        return "redirect:contacts";
    }


}
