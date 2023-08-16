package ca.tutic.aoc.common.universe;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Orbit {
    private boolean visited = false;
    private final String name;
    private Orbit parent;
    private List<Orbit> children = new ArrayList<>();

    public Orbit(String name, Orbit parent) {
        this.name = name;
        this.parent = parent;
    }

    public Orbit(String name) {
        this(name, null);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public String getName() {
        return name;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public Orbit getParent() {
        return parent;
    }

    public void setParent(Orbit parent) {
        this.parent = parent;
    }

    public List<Orbit> getChildren() {
        return getChildren(x -> true);
    }

    public List<Orbit> getChildren(Predicate<Orbit> filter) {
        return children.stream()
                       .filter(filter)
                       .collect(Collectors.toList());
                    
    }

    public void addChild(Orbit child) {
        children.add(child);
    }

    public boolean hasChild(Orbit child) {
        return children.contains(child);
    }

    public boolean hasChild(String childName) {
        for (Orbit child: children) {
            if (child.getName().equals(childName)) {
                return true;
            }
        }
        return false;
    }
}