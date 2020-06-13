package com.company.Tower;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 16:14
 * @version: 2.0
 * @modified By:
 */
public class HandlerGo extends Handler {
    public HandlerGo(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word){
        game.goRoom(word);
    }

}
