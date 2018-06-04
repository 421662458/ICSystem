package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */

//������
@Entity
@Table(name="tb_exchange_student")
public class ExchangeStudent {
    private int id;
    private String schoolName;//������ѧУ
    private String schoolType;//��������
    private String replaceCourse;//�滻�γ�
    private String replaceCredit;//�滻ѧ��
    private Date goAbroadTime;//����ʱ��
    private List<InternationalStudent> studentList = new ArrayList<InternationalStudent>();//����������ʰ�ѧ��һ��һ

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 20)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Column(length = 20)
    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    @Column(length = 20)
    public String getReplaceCourse() {
        return replaceCourse;
    }

    public void setReplaceCourse(String replaceCourse) {
        this.replaceCourse = replaceCourse;
    }

    @Column(length = 20)
    public String getReplaceCredit() {
        return replaceCredit;
    }

    public void setReplaceCredit(String replaceCredit) {
        this.replaceCredit = replaceCredit;
    }

    public Date getGoAbroadTime() {
        return goAbroadTime;
    }

    public void setGoAbroadTime(Date goAbroadTime) {
        this.goAbroadTime = goAbroadTime;
    }

    /* ����������ʰ�ѧ��һ��һ
     *   targetEntity����Ӧ��Ŀ��ʵ����(���ʰ�ѧ��)
     *   mappedBy����Ӧ���Է��������ֶ�
   * */
    @OneToMany(mappedBy="exchangeStudent", targetEntity = InternationalStudent.class)
    public List <InternationalStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List <InternationalStudent> studentList) {
        this.studentList = studentList;
    }
}
