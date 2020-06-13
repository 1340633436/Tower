package com.company.Tower;

import java.util.HashMap;
import java.util.Scanner;

import com.company.Creature.Monster;
import com.company.Creature.MonsterFlower;
import com.company.Creature.MonsterTree;
import com.company.Creature.Person;

/**
 * @description:
 * @author: 邓建军
 * @date: Created in 2020/6/13 19:17
 * @version: 2.0
 * @modified By:
 */
public class Game {
    private Room currentRoom;
    private HashMap<String,Handler> handlers = new HashMap<String,Handler>();
    private Person person= new Person("P1","勇士",200,0,30);

    public Game()
    {
        handlers.put("go",new HandlerGo(this));
        handlers.put("bye",new HandlerBye(this));
        handlers.put("help",new HandlerHelp(this));
        handlers.put("Attack",new HandlerAttack(this));
        handlers.put("A",new HandlerAttack(this));
        handlers.put("Bp",new HandlerBackpack(this));
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;

        //	制造房间
        outside = new Room("奇异城堡外");
        lobby = new Room("大厅");
        pub = new Room("藏宝室");
        study = new Room("地窖");
        bedroom = new Room("密室");


        outside.setMonster(new MonsterFlower("a1", "花妖", 100, 0,20));
        lobby.setMonster(new MonsterFlower("a1", "花妖", 100, 0,20));
        pub.setMonster(new MonsterTree("b1","树妖", 150, 0,15));
        study.setMonster(new MonsterTree("b1","树妖",150,0,15));
        bedroom.setMonster(new MonsterFlower("a1", "花妖", 100, 0,20));

        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        lobby.setExit("west", outside);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);

        currentRoom = outside;  //	从城堡门外开始
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("勇士，欢迎你来到奇异城堡！");
        System.out.println("首先，我要说明，这是一个超级无聊又憨憨的游戏。");
        System.out.println("这个城堡原本被许多植物环绕守护，但由于污染，植物们发生了变异，变成了游荡在城堡里的怪物");
        System.out.println("只有真正的勇士，才能用他的智慧和勇气拯救这座城堡！");
        System.out.println("如果你需要什么帮助，请输入指令 'help' 。");
        System.out.println("只要你击败了所有怪物，即可获取游戏胜利！！！");
        System.out.println("当你的能量条满了，就会自动放技能，强化平a伤害");
        System.out.println("打怪物会获得道具，道具有血瓶（加满血条）或者能量瓶（加满能量条）");
        System.out.println("你可以通过打开背包Bp来使用道具");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
        showPrompt();

    }

    public void showPrompt(){
        System.out.println("------------------------------------");
        System.out.println(person.base());
        System.out.print("这里存在的怪物: ");
        System.out.println(currentRoom.getMonsterDesc());
        System.out.println("------------------------------------");
        System.out.println("现在你在" + currentRoom);
        System.out.print("出口有：");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }

    // 以下为用户命令

    public  void printHelp()
    {
        System.out.print("勇士，你迷路了吗？你可以做的命令有：go bye help Attack Backpack(bp)");
        System.out.println("如：\tgo east");
    }


    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if (words.length > 1)
                value = words[1];
            if (handler != null) {
                if (handler.isBye()) {
                    break;
                }else if(handler.isBackpack()){
                    handler.doCmd();

                }
                else{
                    handler.doCmd(value);
                }
            }
            if(Perjudge(person)==0)
            {
                System.out.println('\n');
                System.out.println("你当前血量为"+person.get_hp());
                System.out.println("GAME OVER!!");
                break;
            }else{
                currentRoom.Monjudge(person);
            }
            if(gameWin()==1)
            {
                break;
            }
            showPrompt();

        }
        in.close();
    }

    public int  gameWin(){
        if(Person.get_left_monster()==0)
        {
            System.out.println("\n"+"\n");
            System.out.println("\t"+"You Win!!!!");
            return 1;
        }
        return 0;
    }
    public void goRoom(String direction) {

        Room nextRoom = currentRoom.getRoom(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门哦！");
        } else {
            currentRoom = nextRoom;

        }

    }
    public Monster getCuMonster(String monster_id)
    {
        return currentRoom.getMonster(monster_id);
    }
    public void PerAttack(Monster monster)
    {
        person.Attack(monster);
    }
    public Person getPerson(){
        return person;
    }
    public int Perjudge(Person person)
    {
        person.hp_judge();
        if(person.get_status()==0)
        {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.printWelcome();
        game.play();
    }
}
