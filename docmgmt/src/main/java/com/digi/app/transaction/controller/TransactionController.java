package com.digi.app.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("transaction")
public class TransactionController {

    @GetMapping(path = "/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("transaction/transactionForm");
        return modelAndView;
    }
}
