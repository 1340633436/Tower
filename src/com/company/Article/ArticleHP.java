package com.company.Article;

import com.company.Creature.Person;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 14:19
 * @version: 2.0
 * @modified By:
 */
public class ArticleHP extends Article {
    public ArticleHP(String id,String discribe,int use_times)
    {
        super(id, discribe, use_times);
    }
    public void play_role(Person person){
        person.set_hp(200);
        System.out.println("你满血了，可以放心继续游戏！");
        super.play_role(person);
    }
}
