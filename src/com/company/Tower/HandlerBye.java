package com.company.Tower;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 16:19
 * @version: 2.0
 * @modified By:
 */
public class HandlerBye extends Handler {
    public HandlerBye(Game game){
        super(game);
    }
    @Override
    public boolean isBye(){
        return true;
    }
}
