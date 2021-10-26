package com.example.demo.controllers;
import com.example.demo.models.Subscription;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.LoanRepository;
import com.example.demo.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("")
    public String viewSubscriptionsPage(Model model) {
        List<Subscription> listSubscriptions = this.getAllSubscriptions();
        model.addAttribute("listSubscriptions", listSubscriptions);
        return "subscriptions";
    }

    @GetMapping("/add-form")
    public String viewAddSubscriptionPage(Model model) {
        Subscription subscription = new Subscription();
        model.addAttribute("subscription", subscription);
        model.addAttribute("listCustomers", customerRepository.findAll());
        model.addAttribute("listLoans", loanRepository.findAll());
        return "add_subscription";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditSubscriptionLoan(@PathVariable(name = "id") int id, Model model) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(id);
        model.addAttribute("subscription", subscription);
        model.addAttribute("listLoans", loanRepository.findAll());
        return "edit_subscription";
    }

    //------------------------------------------------------------------------------------------------

    @GetMapping("/list")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Subscription findSubscriptionById(@PathVariable Integer id) {
        return subscriptionRepository.findSubscriptionById(id);
    }

    @PostMapping("/add")
    public String addSubscription(@ModelAttribute("subscription") Subscription subscription){
        subscriptionRepository.save(subscription);
        return "redirect:/subscriptions";
    }

    @PutMapping("/edit")
    public String editSubscription(@ModelAttribute("subscription") Subscription subscription) {
        subscriptionRepository.save(subscription);
        return "redirect:/subscriptions";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteSubscription(@PathVariable Integer id) {
        subscriptionRepository.delete(this.findSubscriptionById(id));
        return "redirect:/subscriptions";
    }

}
