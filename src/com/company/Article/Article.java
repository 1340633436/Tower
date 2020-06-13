package com.company.Article;

import com.company.Creature.Person;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 13:51
 * @version: 2.0
 * @modified By:
 */
public class Article {
    private String id;
    private String discribe;
    private int use_times;

    public Article(String id,String discribe,int use_times){
        this.id = id;
        this.discribe = discribe;
        this.use_times = use_times;
    }
    public String get_id(){
        return id;
    }
    public void set_id(String id){
        this.id = id;
    }
    public String get_dis(){
        return discribe;
    }
    public void set_dis(String discribe){
        this.discribe = discribe;
    }
    public int get_useTimes(){
        return use_times;
    }
    public void set_useTimes(int use_times)
    {
        this.use_times = use_times;
    }
    public void play_role(Person person){
        use_times--;

    }
    public String getBase(){
        StringBuffer sb = new StringBuffer();
        sb.append(get_id());
        sb.append("(");
        sb.append(get_dis());
        sb.append(" 使用次数:");
        sb.append(get_useTimes());
        sb.append(")");
        return sb.toString();
    }
}
