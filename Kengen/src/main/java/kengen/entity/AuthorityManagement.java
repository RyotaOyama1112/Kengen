package kengen.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authoritymanagement")
public class AuthorityManagement {
    @Id
    @Column(name = "userid")
    private String userId;
    
    private String name;
    private String authority1;
    private String authority2;
    private String authority3;
    
    @Column(name = "change_date")
    private Date changeDate;



    // ゲッターとセッター
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority1() {
        return authority1;
    }

    public void setAuthority1(String authority1) {
        this.authority1 = authority1;
    }

    public String getAuthority2() {
        return authority2;
    }

    public void setAuthority2(String authority2) {
        this.authority2 = authority2;
    }

    public String getAuthority3() {
        return authority3;
    }

    public void setAuthority3(String authority3) {
        this.authority3 = authority3;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}
