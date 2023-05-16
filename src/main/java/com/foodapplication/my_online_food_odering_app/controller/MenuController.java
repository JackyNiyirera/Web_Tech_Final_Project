package com.foodapplication.my_online_food_odering_app.controller;

import ch.qos.logback.core.model.Model;
import com.foodapplication.my_online_food_odering_app.models.Menu;
import com.foodapplication.my_online_food_odering_app.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public String listMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menu/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "menu/create";
    }

    @PostMapping("/create")
    public String createMenu(@ModelAttribute("menu") Menu menu) {
        menuService.saveMenu(menu);
        return "redirect:/menus";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Menu menu = menuService.getMenuById(id);
        model.addAttribute("menu", menu);
        return "menu/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMenu(@PathVariable("id") Long id, @ModelAttribute("menu") Menu menu) {
        menu.setId(id);
        menuService.saveMenu(menu);
        return "redirect:/menus";
    }

    @GetMapping("/delete/{id}")
    public String deleteMenu(@PathVariable("id") Long id) {
        menuService.deleteMenu(id);
        return "redirect:/menus";
    }
}
