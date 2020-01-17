package com.indra.prueba.util;

public enum FakeUsers {

    DAVID("david"),
    VICTORIA("victoria"),
    PAULINA( "paulina"),
    JUAN("juan");

    String name;

    FakeUsers(String name){
        this.name = name;
    }

    public static boolean exist(String name){
        for (FakeUsers me : FakeUsers.values()) {
            if (me.name.equalsIgnoreCase(name))
                return true;
        }
        return false;
    }
}
