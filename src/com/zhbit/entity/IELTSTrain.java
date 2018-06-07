package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wby on 2018/4/6.
 */
/*��˼��ѵ*/
@Entity
@Table(name="tb_ielts_train")
public class IELTSTrain {
    private int id;//�������
    private String ieltsTrainId;//��˼�������
    private String trainName;//��˼��������
    private String trainTerm;//��ѵ��ѧ��
    private Date trainTime;//��ѵ��ʱ��
    private String trainClassHours;//��˼�γ�ѧʱ
    private List<IELTSExam> examList;//��˼����
    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    @Column(length = 50,unique = true)
    public String getIeltsTrainId() {
        return ieltsTrainId;
    }

    public void setIeltsTrainId(String ieltsTrainId) {
        this.ieltsTrainId = ieltsTrainId;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(length = 20)
    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    @Column(length = 20)
    public String getTrainTerm() {
        return trainTerm;
    }

    public void setTrainTerm(String trainTerm) {
        this.trainTerm = trainTerm;
    }

    public Date getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Date trainTime) {
        this.trainTime = trainTime;
    }
    @Column(length = 20)
    public String getTrainClassHours() {
        return trainClassHours;
    }

    public void setTrainClassHours(String trainClassHours) {
        this.trainClassHours = trainClassHours;
    }

    /*��˼��ѵ�ٰ���˼����1->n*/
    @OneToMany(mappedBy="ieltsTrain", targetEntity = IELTSExam.class)
    public List <IELTSExam> getExamList() {
        return examList;
    }

    public void setExamList(List <IELTSExam> examList) {
        this.examList = examList;
    }
}
