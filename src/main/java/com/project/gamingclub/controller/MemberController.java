package com.project.gamingclub.controller;

import com.project.gamingclub.entity.members;
import com.project.gamingclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public members create(@RequestBody members member) {
        return memberService.create(member);
    }

    @GetMapping
    public List<members> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public members getById(@PathVariable String id) {
        return memberService.findById(id);
    }

    @PutMapping("/{id}")
    public members update(@PathVariable String id, @RequestBody members member) {
        return memberService.update(id, member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        memberService.delete(id);
    }
}
