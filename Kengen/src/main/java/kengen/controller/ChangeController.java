package kengen.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kengen.entity.AuthorityManagement;
import kengen.service.AuthorityManagementService;

@Controller
public class ChangeController {

    @Autowired
    private AuthorityManagementService authorityManagementService;

    @GetMapping("/change/{userId}")
    public String showChangeForm(@PathVariable String userId, Model model) {
        AuthorityManagement authority = authorityManagementService.findById(userId);
        if (authority != null) {
            model.addAttribute("authority", authority);
            return "change";
        } else {
            return "redirect:/authorities"; // 権限情報が見つからない場合は一覧画面にリダイレクト
        }
    }
    
    @PostMapping("/change") // フォームの送信先を指定
    public String changeAuthority(@ModelAttribute AuthorityManagement authority) {
        // 変更された日時を設定
        authority.setChangeDate(new Date());
    	// 権限管理情報を保存（更新）
        authorityManagementService.save(authority);
        // 変更後の画面にリダイレクト
        return "redirect:/authorities";
    }
}
