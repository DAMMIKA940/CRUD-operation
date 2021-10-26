package com.example.demo.controllers;

import com.example.demo.models.Loan;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("")
    public String viewPackagesPage(Model model) {
        List<Loan> listLoans = this.getAllLoans();
        model.addAttribute("listLoans", listLoans);
        return "loans";
    }

    @GetMapping("/add-form")
    public String viewAddLoanPage(Model model) {
        Loan p = new Loan();
        model.addAttribute("loan", p);
        return "add_loan";
    }

    @GetMapping("/edit-form/{id}")
    public String showEditLoanPage(@PathVariable(name = "id") int id, Model model) {
        Loan p = loanRepository.findLoanById(id);
        model.addAttribute("p", p);
        return "edit_loan";
    }

    //------------------------------------------------------------------------------------------------

    @GetMapping("/list")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Loan findLoanById(@PathVariable Integer id) {
        return loanRepository.findLoanById(id);
    }

    @PostMapping("/add")
    public String addLoans(@ModelAttribute("p") Loan p){
        loanRepository.save(p);
        return "redirect:/loans";
    }

    @PutMapping("/edit")
    public String editLoan(@ModelAttribute(value="p") Loan p) {
        loanRepository.save(p);
        return "redirect:/loans";
    }

    @DeleteMapping("/delete/{id}")
    private String deleteLoan(@PathVariable Integer id) {
        loanRepository.delete(this.findLoanById(id));
        return "redirect:/loans";
    }

}
