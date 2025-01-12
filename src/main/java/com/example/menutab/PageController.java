package com.example.menutab;

import com.example.menutab.model.MenuItem;
import com.example.menutab.model.Tab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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


        // 메뉴 가져오기
        getMenu(model);
        getLeftMenu(model);
//        getTabs(model);

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

    @GetMapping("/leftMenu")
    public String getLeftMenu(Model model) {
        MenuItem root = new MenuItem(0, "Root", null);

        //1depth
        MenuItem userManagement = new MenuItem(1, "User Management", null);
        MenuItem board = new MenuItem(2, "Board", null);
        root.addChildren(userManagement);
        root.addChildren(board);

        //2depth
        MenuItem account = new MenuItem(3, "Account", null);
        MenuItem personnel = new MenuItem(4, "Personnel", null);

        userManagement.addChildren(account);
        userManagement.addChildren(personnel);

        MenuItem notice = new MenuItem(5, "Notice", null);
        MenuItem downloads = new MenuItem(6, "Downloads", null);

        board.addChildren(notice);
        board.addChildren(downloads);


        //3depth
        MenuItem test = new MenuItem(10, "Test", null);
        account.addChildren(test);


        model.addAttribute("leftMenu", root);
        return "leftMenu";
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem(7, "Home", "/home"),
                new MenuItem(8, "About", "/about"),
                new MenuItem(9, "Contact", "/contact")
        );
        model.addAttribute("menuItems", menuItems);
        return "menu"; // Thymeleaf 템플릿 이름
    }

    @GetMapping("/tabs")
    public String getTabs(Model model) {
        List<Tab> tabs = Arrays.asList(
                new Tab("tab1", "Tab 1", "This is the content for Tab 1.", true),
                new Tab("tab2", "Tab 2", "This is the content for Tab 2.", false),
                new Tab("tab3", "Tab 3", "This is the content for Tab 3.", false)
        );
        model.addAttribute("tabs", tabs);
        model.addAttribute("currentTime", LocalDateTime.now().toString());
        return "tabs"; // Thymeleaf 템플릿 이름
    }
}