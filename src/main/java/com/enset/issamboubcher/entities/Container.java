package com.enset.issamboubcher.entities;

import com.enset.issamboubcher.aspects.SecuredBy;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private final Map<String, Agent> agentMap;

    public Container() {
        this.agentMap = new HashMap<>();
    }

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    @SecuredBy(roles = {"admin"})
    public void addAgent(Agent agent) {
        agentMap.put(agent.getName(), agent);
    }

    @SecuredBy(roles = {"admin"})
    public void removeAgent(String agentName) {
        agentMap.remove(agentName);
    }

    @SecuredBy(roles = {"admin"})
    public void getAgent(String agentName) {
        agentMap.get(agentName);
    }

    public void displayAllAgents() {
        agentMap.forEach((key, agent) -> agent.printAgent());
    }
}
