package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/6/3.
 */
//�û���
@Entity
@Table(name="tb_admin_user")
public class AdminUser {
    private int id;
    private String userNo;//�û����
    private String userName;//�û���
    private String name;//�û�����
    private String nickName;//�ǳ�
    private String password;//����
    private String loginIp;//��¼ip
    private Date loginDate;//���һ�ε�¼ʱ��
    private String photo;//�û�ͷ��
    private String phone;//��ϵ�绰
    private String email;//����
    private Date birthday;//����
    private int gender;//�Ա� �Ա� 0���� 1��  2Ů
    private int collegeId;//����id
    private int locked;// DEFAULT'0' COMMENT �Ƿ����� 1���� 0δ����',
    private String remark;//����
    private String status;//DEFAULT '1' COMMENT '1����  0ɾ�� -1ȫ��'
    private Date createDate;//����ʱ��
    private Date updateDate;//����ʱ��
    private int creator;//������
    private int updater;//������
    private List<UserRole>userRoleList;
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length=128)
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    @Column(length=64)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(length=64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length=64)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    @Column(length=128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(length=128)
    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    @Column(length=512)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    @Column(length=16)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Column(length=64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Column(length=2)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
    @Column(length=11)
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }
    @Column(length=1)
    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
    @Column(length=512)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Column(length=1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    @Column(length=20)
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    @Column(length=20)
    public int getUpdater() {
        return updater;
    }

    public void setUpdater(int updater) {
        this.updater = updater;
    }
    @OneToMany(mappedBy = "adminUser",targetEntity = UserRole.class)
    public List <UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List <UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

}
