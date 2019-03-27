package org.crazycake.shiroredisspringboottutorial.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/data")
    public String showData() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return "Hello:";
    }

    @GetMapping("/sessionData")
    public String sessionDataShow() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        return "Checking Session Data: " + session.getId();
    }

    @GetMapping("/sessionLogout")
    public String sessionLogout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "Logout: " ;
    }
}
