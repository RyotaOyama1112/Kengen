package kengen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kengen.entity.AuthorityManagement;
import kengen.entity.User;
import kengen.form.UserForm;
import kengen.service.AuthorityManagementService;
import kengen.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityManagementService authorityService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registerUser(UserForm userForm) {
        // UserFormデータを使用してユーザーを保存
        userService.saveUser(userForm);

        // 新しい AuthorityManagement エンティティを作成し、初期値を設定
        AuthorityManagement authorityManagement = new AuthorityManagement();
        authorityManagement.setUserId(userForm.getUserID());
        authorityManagement.setName(userForm.getName());
        authorityManagement.setAuthority1("なし");
        authorityManagement.setAuthority2("なし");
        authorityManagement.setAuthority3("なし");
        authorityManagement.setChangeDate(new java.sql.Date(System.currentTimeMillis()));

        // AuthorityManagement を保存
        authorityService.save(authorityManagement);

        return "redirect:/login"; // 登録後にログイン画面にリダイレクト
    }
}
