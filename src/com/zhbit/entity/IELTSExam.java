package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wby on 2018/4/6.
 */
/*��˼����*/
@Entity
@Table(name="tb_ielts_exam")
public class IELTSExam {
    private int id;
    private Date examTime;//��˼����ʱ��
    private String examPlace;//��˼���Եص�
    private int score;//����
    private IELTSTrain ieltsTrain;//��ѵ����

    @Id
    @GeneratedValue(generator="_native")
    @GenericGenerator(name="_native",strategy="native")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
    @Column(length=50)
    public String getExamPlace() {
        return examPlace;
    }

    public void setExamPlace(String examPlace) {
        this.examPlace = examPlace;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @ManyToOne
    @JoinColumn(name="ieltsTrainId")
    public IELTSTrain getIeltsTrain() {
        return ieltsTrain;
    }

    public void setIeltsTrain(IELTSTrain ieltsTrain) {
        this.ieltsTrain = ieltsTrain;
    }
}
