package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/6/3.
 */
//��ɫ�����Դ����м��
@Entity
@Table(name="tb_role_resource")
public class RoleResource {
    private int id;
    private Role role;
    private Resources resources;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne//��Դ-��ɫ���м��ͽ�ɫ��Ĺ�ϵ
    @JoinColumn(name="role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne//��Դ-��ɫ���м��ͽ�ɫ��Ĺ�ϵ
    @JoinColumn(name="resource_id")
    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
