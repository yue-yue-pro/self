package com.yueyue.controller;

import com.yueyue.pojo.Account;
import com.yueyue.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Account> accounts = accountService.queryAll();
        model.addAttribute("accounts", accounts);
        return "/list";
    }
    @RequestMapping("/add")
    public String add(Account account){
        accountService.add(account);
        return "redirect:/account/queryAll";
    }
}