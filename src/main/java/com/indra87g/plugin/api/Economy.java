package com.indra87g.plugin.api;

import me.onebone.economyapi.EconomyAPI;
import cn.nukkit.Player;

public class Economy {

    private final EconomyAPI economyAPI;

    public Economy() {
        this.economyAPI = EconomyAPI.getInstance();
    }

    public double getMoney(Player player) {
        return economyAPI.myMoney(player);
    }

    public void addMoney(Player player, double amount) {
        economyAPI.addMoney(player, amount);
    }

    public void reduceMoney(Player player, double amount) {
        economyAPI.reduceMoney(player, amount);
    }

    public void setMoney(Player player, double amount) {
        economyAPI.setMoney(player, amount);
    }
}
