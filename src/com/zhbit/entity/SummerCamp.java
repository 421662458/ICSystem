package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
//����Ӫ�
@Entity
@Table(name="tb_summer_camp")
public class SummerCamp {
    private int id;
    private Date activityTime;
    private List<InternationalStudent> studentList=new ArrayList<InternationalStudent>();//һ���༶��Ϣ����������ʰ�ѧ��

    /* �������ñ��أ�mysql�ı�����������
    *
    * */
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getActivityTime() {
        return activityTime;
    }
    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    /*  ����Ӫ�͹��ʰ�ѧ����һ�Զ�Ķ�Ӧ��ϵ
    *   targetEntity����Ӧ��Ŀ��ʵ����(���ʰ�ѧ��)
    *   mappedBy����Ӧ���Է��������ֶ�
    * */
    @OneToMany(mappedBy="summerCamp",targetEntity = InternationalStudent.class)
    public List <InternationalStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List <InternationalStudent> studentList) {
        this.studentList = studentList;
    }
}
