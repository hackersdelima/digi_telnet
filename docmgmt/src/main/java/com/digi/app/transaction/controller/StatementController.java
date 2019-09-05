package com.digi.app.transaction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("statement")
public class StatementController {

    @GetMapping(path = "/searchForm")
    public ModelAndView searchForm() {
        ModelAndView modelAndView = new ModelAndView("transaction/statementSearchForm");
        return modelAndView;
    }

    @GetMapping(path = "/table")
    public ModelAndView searchResultTable() {
        ModelAndView modelAndView = new ModelAndView("transaction/statementTable");
        return modelAndView;
    }

    @GetMapping(path = "/searchResultJson")
    public String searchResult(String accountNumber, String dateFrom, String dateTo) {
        //TODO: get Json values from socket function and return statementDTO
        return null;
    }

}
