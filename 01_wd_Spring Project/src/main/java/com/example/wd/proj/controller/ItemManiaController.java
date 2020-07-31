package com.example.wd.proj.controller;

import com.example.wd.proj.entity.ItemManiaBoard;
import com.example.wd.proj.service.ItemManiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemManiaService maniaService;

    @GetMapping("/mania_list")
    public String contList(Model model) throws Exception {
        log.info("m_list()");

        model.addAttribute(
                "list_wd",
                maniaService.maniaList());

        return "board/mania_list";
    }

    @GetMapping("/getManiaRegister")
    public String getManiaRegister(ItemManiaBoard board, Model model) throws Exception {
        log.info("getManiaRegister()");

        return "board/mania_register";
    }

    @PostMapping("/postManiaRegister")
    public String postManiaRegister(ItemManiaBoard board, Model model) throws Exception {
        log.info("postManiaRegister()");

        maniaService.maniaRegister(board);

        model.addAttribute(
                "regi_msg",
                "아이템 등록 성공");

        return "board/mania_success";
    }


}
