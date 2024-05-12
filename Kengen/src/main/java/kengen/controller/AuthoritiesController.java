package kengen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kengen.service.AuthorityManagementService;

@Controller
public class AuthoritiesController {

    @Autowired
    private AuthorityManagementService authorityManagementService;

    @GetMapping("/authorities")
    public String showAuthorities(Model model) {
        // すべての権限情報を取得
        model.addAttribute("authorities", authorityManagementService.findAll());
        return "authorities";  // 一覧表示画面のビュー名
    }
}
