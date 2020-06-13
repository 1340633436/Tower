package com.company.Creature;

import com.company.Article.Article;

import com.company.Article.ArticleSet;


/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/12 17:40
 * @version: 2.0
 * @modified By:
 */
public class Person extends Creature{
    private static int left_monster;
    private ArticleSet articleSet = new ArticleSet();
    public Person(String id,String discribe,int hp,int anger_value,int attack_value){
        super(id,discribe,hp,anger_value,attack_value);
        set_left_monster();
    }



    public static void set_left_monster(){
        left_monster=0;
    }

    public static void left_monster_add(){
        left_monster++;
    }

    public static int get_left_monster(){
        return left_monster;
    }

    public static void left_monster_del(){
        left_monster--;
    }
    public String base(){
        StringBuffer sb = new StringBuffer();
        sb.append(get_dis());
        sb.append("  血量:");
        sb.append(get_hp());
        sb.append("  能量:");
        sb.append(get_ag_value());
        return sb.toString();
    }
    public void addArticle(Article article){
        articleSet.add(article);
    }
    //攻击
    public void Attack(Monster monster){
        int damage=get_attack_value();
        if(anger_value>=100)
        {
            System.out.println("能量已经积攒完毕，你可以使用使用必杀技了！");
            damage =100;
            anger_value=0;
        }
        System.out.print("你");
        System.out.print("对");
        System.out.print(monster.get_dis());
        System.out.print("造成了");
        System.out.print(damage);
        System.out.println("伤害");
        int now_hp = monster.get_hp() - damage;
        int now_ag_value = monster.get_ag_value()+get_attack_value();
        monster.set_hp(now_hp);
        monster.set_ag_value(now_ag_value);

    }
    public void hp_judge(){
        if(hp <= 0)
        {
            set_status(0);
        }
    }
    public String getArticleDes(){
        return articleSet.getArticle();
    }

    public Article getArticle(String id){
        return articleSet.get_article(id);
    }
    public void ArticleJudge(){
        articleSet.Articlejudge();
    }
}
