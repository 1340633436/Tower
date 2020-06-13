package com.company.Tower;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 15:06
 * @version: 2.0
 * @modified By:
 */
public class Handler {
    protected Game game;
    public Handler(Game game){
        this.game = game;
    }
    public void doCmd(String word){}
    public void doCmd(){}
    public boolean isBye(){return false;}
    public boolean isBackpack(){return false;}
}
