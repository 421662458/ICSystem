package com.zhbit.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by wby on 2018/4/6.
 */
/* ���ʰ���˼����
*
*  ���ʰ�ѧ�������˼���Ե��м��
*
* */
@Entity
@Table(name="tb_interstu_exam")
public class InterStuExam {
    private int id;
    private IELTSExam ieltsExam;//��˼���Եı��
    private InternationalStudent internationalStudent;//���ʰ�ѧ����ѧ��
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
    @JoinColumn(name="ieltsExamId")
    public IELTSExam getIeltsExam() {
        return ieltsExam;
    }

    public void setIeltsExam(IELTSExam ieltsExam) {
        this.ieltsExam = ieltsExam;
    }

    @ManyToOne
    @JoinColumn(name="internationalStudentId")
    public InternationalStudent getInternationalStudent() {
        return internationalStudent;
    }

    public void setInternationalStudent(InternationalStudent internationalStudent) {
        this.internationalStudent = internationalStudent;
    }
}
