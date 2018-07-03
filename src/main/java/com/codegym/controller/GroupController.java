package com.codegym.controller;

import com.codegym.model.Group;
import com.codegym.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/groups")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("")
    public ModelAndView getAllGroup(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/group/list");

        Page<Group> groups = groupService.findAll(pageable);

        modelAndView.addObject("groups", groups);

        return modelAndView;
    }
}
