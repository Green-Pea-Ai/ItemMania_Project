package com.example.wd.proj.controller;

import com.example.wd.proj.service.ItemManiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemManiaService mania_service;

    @GetMapping("/mania_list")
    public String list(Model model) throws Exception {
        log.info("m_list()");

        model.addAttribute(
                "list_wd",
                mania_service.mania_list());

        return "board/mania_list";
    }
}
