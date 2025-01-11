package com.example.menutab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(Model model) {
        return home(model);
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Home");

        // 현재 시간 가져오기
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        // Model에 현재 시간 추가
        model.addAttribute("currentTime", formattedNow);

        return "layout";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Us");
        return "layout";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact Us");
        return "layout";
    }

    @GetMapping("/menuTree")
    public String menuTree(Model model) {
        model.addAttribute("pageTitle", "About Us");
        return "menuTree";
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        List<MenuItem> menuItems = List.of(
                new MenuItem("Home", "/home", true),
                new MenuItem("About", "/about", false),
                new MenuItem("Contact", "/contact", false)
        );
        model.addAttribute("menuItems", menuItems);
        return "menu"; // Thymeleaf 템플릿 이름
    }

    @GetMapping("/tabs")
    public String getTabs(Model model) {
        List<Tab> tabs = List.of(
                new Tab("tab1", "Tab 1", "This is the content for Tab 1.", true),
                new Tab("tab2", "Tab 2", "This is the content for Tab 2.", false),
                new Tab("tab3", "Tab 3", "This is the content for Tab 3.", false)
        );
        model.addAttribute("tabs", tabs);
        model.addAttribute("currentTime", LocalDateTime.now().toString());
        return "tabs"; // Thymeleaf 템플릿 이름
    }
}