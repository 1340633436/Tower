package com.company.Creature;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/12 17:37
 * @version: 2.0
 * @modified By:
 */
public class Creature {
    String id;
    String discribe;
    int hp;
    int anger_value;
    int attack_value;
    int status;
    public Creature(String id,String discribe,int hp,int anger_value,int attack_value){
        this.id = id;
        this.discribe = discribe;
        this.hp = hp;
        this.anger_value = anger_value;
        this.attack_value = attack_value;
        status =1;
    }
    public String get_id(){
        return id;
    }
    public void set_Id(String id){
        this.id = id;
    }
    public String get_dis(){
        return discribe;
    }
    public void set_dis(String discribe){
        this.discribe = discribe;
    }
    public int get_hp(){
        return hp;
    }
    public void set_hp(int hp){
        this.hp = hp;
    }
    public int get_ag_value(){
        return anger_value;
    }
    public void set_ag_value(int anger_value){
        this.anger_value = anger_value;
    }
    public int get_attack_value(){
        return attack_value;
    }
    public void set_attack_value(int attack_value){
        this.attack_value = attack_value;
    }
    public int get_status(){
        return status;
    }
    public void set_status(int status){
        this.status = status;
    }
    public void Nirvana(){};
    public void hp_judge(){

    }
}
