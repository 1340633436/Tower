package com.company.Tower;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 17:01
 * @version: 2.0
 * @modified By:
 */
public class HandlerHelp extends Handler {
    public HandlerHelp(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word){
        game.printHelp();
    }
}
