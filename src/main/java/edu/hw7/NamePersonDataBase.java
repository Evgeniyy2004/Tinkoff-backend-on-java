package edu.hw7;

import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class NamePersonDataBase {

    HashMap<String,Person> all = new HashMap<>();
    public synchronized void add(Person person) {
        all.put(person.name(), person);
    }
    public synchronized Person delete(String name) {
        if (all.containsKey(name)) return all.remove(name);
        else return null;
    }
    public synchronized Person findBy(@NotNull String name) {
        if (all.containsKey(name)) return all.get(name);
        return null;
    }

}