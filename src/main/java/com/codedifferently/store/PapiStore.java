package com.codedifferently.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PapiStore {
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    Map<String, Double> owesPapiMoney;

    public PapiStore(){
        this.isStoreOpen = false;
        this.tabs = new ArrayList();
        this.owesPapiMoney = new HashMap<>();
    }

    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    public void closeStore(){

    }

    public void openStore(){
        this.isStoreOpen = true;
    }

    public boolean isStoreOpen() {
        return isStoreOpen;
    }


    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            response = true;
        return response;
    }

    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }

    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        return false;
    }

    public void createActiveTab(String name){
        this.tabs.add(name);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
