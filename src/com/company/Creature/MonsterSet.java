package com.company.Creature;

import java.util.HashMap;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/12 17:40
 * @version: 2.0
 * @modified By:
 */
public class MonsterSet {
    private HashMap<String, Monster> monsterSets = new HashMap<String, Monster>();

    public MonsterSet(){}

    public void MonsterInit(String name,Monster monster){
        monsterSets.put(name,monster);
    }

    public String getMonsterDes(){
        StringBuffer sb = new StringBuffer();
        for(Monster dir : monsterSets.values())
        {
            sb.append(dir.get_base());
            sb.append(' ');
        }
        return sb.toString();
    }
    public Monster getMonster(String monster_id)
    {
        return monsterSets.get(monster_id);
    }



    public void Monjudge(Person person){
        for(Monster dir : monsterSets.values())
        {
            dir.hp_judge();
            if(dir.get_status()==0)
            {
                dir.Article_judge(person);
                monsterSets.remove(dir.get_id());
                Person.left_monster_del();
            }
        }
    }
}
