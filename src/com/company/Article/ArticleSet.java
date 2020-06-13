package com.company.Article;

import java.util.HashMap;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 12:28
 * @version: 2.0
 * @modified By:
 */
public class ArticleSet {
    HashMap<String,Article> article_set = new HashMap<String,Article>();
    public ArticleSet(){}
    public void add(Article article)
    {
        article_set.put(article.get_id(),article);
    }
    public void Articlejudge()
    {
        for(Article dir:article_set.values())
        {
            if(dir.get_useTimes() == 0)
                article_set.remove(dir.get_id());
        }
    }
    public String getArticle(){
        StringBuffer sb = new StringBuffer();
        int n=0;
        for(Article dir:article_set.values())
        {
            sb.append(dir.getBase());
            sb.append('\n');
            n=1;
        }
        if(n==0)
        {
            System.out.println("背包空空的哦，快去寻找道具吧");
        }
        return sb.toString();
    }
    public Article get_article(String id)
    {
        return article_set.get(id);
    }
}
