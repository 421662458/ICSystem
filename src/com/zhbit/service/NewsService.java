package com.zhbit.service;

import com.zhbit.entity.News;
import com.zhbit.entity.PageBean;
import com.zhbit.util.StringUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wby on 2018/5/28.
 */
//����
public interface NewsService {
    /**
     * չʾ�������ţ�����չʾ1-8����������
     * @param s_news
     * @param pageBean
     * @return
     */
    public List<News> showNewsList(News s_news, PageBean pageBean);

    /**
     * ����id �����������
     * @param newsId
     * @return
     */
    public News getNewsById(int newsId);

    /**
     * �����ܼ�¼��
     * @param s_news
     * @return
     */
    public Long getNewsCount(News s_news);


}
