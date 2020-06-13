package com.company.Article;

import com.company.Creature.Person;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 14:11
 * @version: 2.0
 * @modified By:
 */
public class ArticleEn extends Article {
    public ArticleEn(String id,String discribe,int use_times){
        super(id, discribe, use_times);
    }
    public void play_role(Person person)
    {
        person.set_ag_value(100);
        System.out.println("你能量条满了，快上前攻击！");
        super.play_role(person);
    }
}
