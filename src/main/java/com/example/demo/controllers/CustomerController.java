package com.example.demo.controllers;

import org.springframework.ui.Model;
import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public String viewCustomersPage(Model model) {
        List<Customer> listCustomers = this.getAllCustomers();
        model.addAttribute("listCustomers", listCustomers);

        return "customers";
    }

    @GetMapping("/add-form")
    public String viewAddCustomerPage(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "add_customer";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditCustomerPage(@PathVariable(name = "id") int id, Model model) {
        Customer customer = customerRepository.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    //------------------------------------------------------------------------------------------------

    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @PostMapping("/add")
    public String addPackage(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PutMapping("/edit")
    public String editPackage(@ModelAttribute(value="customer") Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteCustomer(@PathVariable Integer id) {
        customerRepository.delete(this.findCustomerById(id));
        return "redirect:/customers";
    }

}
