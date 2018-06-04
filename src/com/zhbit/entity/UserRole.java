package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/6/3.
 */
//�û�-��ɫ���м��
@Entity
@Table(name="tb_user_role")
public class UserRole {
    private int id;
    private AdminUser adminUser;
    private Role role;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name="user_id")//�û�-��ɫ���м����û���Ĺ�ϵ
    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
    @ManyToOne//�û�-��ɫ���м��ͽ�ɫ��Ĺ�ϵ
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
