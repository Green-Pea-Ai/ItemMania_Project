package com.example.wd.proj.controller;

import com.example.wd.proj.entity.ItemManiaBoard;
import com.example.wd.proj.service.ItemManiaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ItemManiaController {
    private static final Logger log =
            LoggerFactory.getLogger(ItemManiaController.class);

    @Autowired
    private ItemManiaService maniaService;

    // list : 아이템 리스트 보기 =========================================================================================
    @GetMapping("/mania_list")
    public String contList(Model model) throws Exception {
        log.info("m_list()");

        model.addAttribute(
                "list_wd",
                maniaService.maniaList());

        return "board/mania_list";
    }

    // register : 아이템 등록 =========================================================================================
    @GetMapping("/getManiaRegister")
    public String getManiaRegister(@ModelAttribute("board") ItemManiaBoard board, Model model) throws Exception {
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

    // remove : 아이템 삭제 =========================================================================================
    @PostMapping("/mania_remove")
    public String contRemove(int custNo, Model model) throws Exception {
        log.info("contRemove()");

        //ServImpl에 코드를 작성해줘야 삭제가 작동한다?
        maniaService.removeFromServ(custNo);

        model.addAttribute("remove_msg", "Delete Success!");

        return "board/mania_success";
    }

    // read : 아이템 상세보기 =========================================================================================
    @GetMapping("/mania_read")
    public String contRead(int custNo, Model model) throws Exception {
        log.info("contRead()");

        /*org.thymeleaf.exceptions.TemplateProcessingException:
        Error during execution of processor 'org.thymeleaf.spring5.
        processor.SpringInputGeneralFieldTagProcessor'
        (template: "board/mania_read" - line 33, col 16)*/

        /*Caused by: org.springframework.beans.NotReadablePropertyException:
        Invalid property 'customerNo' of bean class [java.lang.String]:
        Bean property 'customerNo' is not readable or has an invalid getter method:
        Does the return type of the getter match the parameter type of the setter?*/

        // model.addAttribute("board", "boardValue");
        model.addAttribute("read_pain", maniaService.readFromServ(custNo));

        return "board/mania_read";
    }

    // modify : 아이템 정보 수정 =========================================================================================
    /*@GetMapping("/getManiaRegister")
    public String getManiaRegister(@ModelAttribute("board") ItemManiaBoard board, Model model) throws Exception {
        log.info("getManiaRegister()");*/

    @GetMapping("/getManiaModify")
    public String getManiaModify(int custNo, Model model) throws Exception {
        log.info("getManiaModify()");

        model.addAttribute("attr_modi", maniaService.readFromServ(custNo));

        return "board/mania_modify";
    }

    @PostMapping("/postManiaModify")
    public String postManiaModify(ItemManiaBoard board, Model model) throws Exception {
        log.info("postManiaModify()");

        maniaService.modifyFromServ(board);

        model.addAttribute("modi_msg", "Modify Success!");

        return "board/mania_success";
    }
}

