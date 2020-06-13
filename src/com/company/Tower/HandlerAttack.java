package com.company.Tower;

import com.company.Creature.Monster;
/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 15:18
 * @version: 2.0
 * @modified By:
 */
public class HandlerAttack extends Handler {
    public HandlerAttack(Game game){
        super(game);
    }

    @Override
    public void doCmd(String id)
    {
        System.out.println();
        Monster monster = game.getCuMonster(id);
        if(monster ==null)
        {
            System.out.println("没有该对象哦");
        }else{
            game.PerAttack(monster);
            game.getCuMonster(id).Attack(game.getPerson());
            System.out.println();
        }

    }
}
