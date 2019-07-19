package com.shams.spring.springbootinmemorycrud.controller;

import com.shams.spring.springbootinmemorycrud.model.Contact;
import com.shams.spring.springbootinmemorycrud.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "list";
    }

    @GetMapping("/details/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "show";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Contact contact) {
        contactService.updateContact(contact);
        return "redirect:/contacts";
    }

    @PostMapping("/create")
    public String create(Contact contact) {
        contactService.createNewContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }




}
