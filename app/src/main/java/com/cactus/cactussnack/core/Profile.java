package com.cactus.cactussnack.core;


import java.util.ArrayList;
import java.util.List;

public class Profile {
    Employe user = new Employe();
    private static List<Command> myCommands = new ArrayList<>();

    public static List<Command> getCommandList(){
        return myCommands;
    }
}
