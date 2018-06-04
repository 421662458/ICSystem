package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wby on 2018/6/2.
 */
//רҵ��Ϣ
@Entity
@Table(name="tb_profession_info")
public class ProfessionInfo {
    private int id;//����
    private String professionName;//רҵ���ƺ�
    private String descInfo;//רҵ����
    private List<ClassesInfo> classesInfoList=new ArrayList<ClassesInfo>();//һ��רҵ���������
    private CollegeInfo collegeInfo;//���רҵ��Ӧһ��ѧԺ


    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length=10)
    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }
    @Lob
    @Column(columnDefinition="TEXT")
    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }
    //һ��רҵ���������
    @OneToMany(mappedBy = "professionInfo",targetEntity = ClassesInfo.class)
    public List <ClassesInfo> getClassesInfoList() {
        return classesInfoList;
    }

    public void setClassesInfoList(List <ClassesInfo> classesInfoList) {
        this.classesInfoList = classesInfoList;
    }
    @ManyToOne
    @JoinColumn(name = "collegeInfoId")
    public CollegeInfo getCollegeInfo() {
        return collegeInfo;
    }

    public void setCollegeInfo(CollegeInfo collegeInfo) {
        this.collegeInfo = collegeInfo;
    }
}
