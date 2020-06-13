package com.company.Tower;

import java.util.HashMap;

import com.company.Creature.Monster;
import com.company.Creature.MonsterSet;
import com.company.Creature.Person;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 18:18
 * @version: 2.0
 * @modified By:
 */
public class Room {
    private String description;
    private HashMap<String,Room> exits = new HashMap<String,Room>();
    private MonsterSet monster_set = new MonsterSet();

    public Room(String description)
    {
        this.description = description;
    }
    public void setExit(String dir,Room room)
    {
        exits.put(dir,room);
    }

    public void setMonster(Monster monster)
    {
        monster_set.MonsterInit(monster.get_id(), monster);
        Person.left_monster_add();
    }

    @Override
    public String toString()
    {
        return description;
    }

    public String getExitDesc(){
        StringBuffer sb = new StringBuffer();
        for(String dir:exits.keySet())
        {
            sb.append(dir);
            sb.append(' ');
        }
        return sb.toString();
    }

    public String getMonsterDesc(){
        return monster_set.getMonsterDes();
    }

    public Room getRoom(String direction){
        return exits.get(direction);
    }

    public Monster getMonster(String monster_id)
    {
        return monster_set.getMonster(monster_id);
    }
    public void Monjudge(Person person){
        monster_set.Monjudge(person);
    }
}
