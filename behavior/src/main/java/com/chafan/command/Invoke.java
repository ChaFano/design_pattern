package com.chafan.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 茶凡
 * @ClassName Invoke
 * @date 2023/11/21 11:03
 * @Description TODO
 */
public class Invoke {


    private List<Command> commands=new ArrayList<>();
    private int index;
    public Invoke add(Command command){
        commands.add(command);
        return this;
    }
    public void invoke(){
        for (int i=index;i<commands.size();i++){
            commands.get(i).execute();
            System.out.println(commands.get(i).toString());
        }
        index=commands.size();
    }


}
