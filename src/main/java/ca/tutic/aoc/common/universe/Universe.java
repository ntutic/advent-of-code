package ca.tutic.aoc.common.universe;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Universe {
    private final Orbit root;
    private HashMap<String, Orbit> directory = new HashMap<>();

    public Universe(String centerOfMass) {
        root = new Orbit(centerOfMass);
        directory.put(centerOfMass, root);
    }

    public HashMap<String, Orbit> getDirectory() {
        return directory;
    }

    public void createOrbit(String parent, String child) {
        directory.putIfAbsent(parent, new Orbit(parent));
        directory.putIfAbsent(child, new Orbit(child, directory.get(parent)));
        directory.get(parent).addChild(directory.get(child));
        if (!directory.get(child).hasParent()) {
            directory.get(child).setParent(directory.get(parent));
        }
    }

    public int countOrbits() {
        int count = 0;
        for (Orbit orbit: directory.values()) {
            count += depth(orbit);
        }
        return count;
    }

    public int depth(Orbit orbit) {
        int count = 0;
        while (orbit.hasParent()) {
            orbit = orbit.getParent();
            count++;
        }
        return count;
    }

    public int orbitalTransfer(String from, String to) {
        directory.get(from).setVisited();
        Orbit source = directory.get(from).getParent();
        Orbit target = directory.get(to).getParent();
        return orbitalTransfer(source.getChildren(x -> !x.isVisited()), target, 0);
    }

    public int orbitalTransfer(List<Orbit> searchSpace, Orbit target, int steps) {
        if (!searchSpace.contains(target)) {
            steps++;
            List<Orbit> children = searchChildren(searchSpace);
            if (children.size() != 0) {
                return orbitalTransfer(children, target, steps);
            } else {
                Orbit parent = searchSpace.get(0).getParent();
                while (parent.isVisited()) {
                    steps--;
                    parent = parent.getParent();
                } 
                return orbitalTransfer(parent.getChildren(x -> !x.isVisited()), target, steps);
            }
        }
        return steps;
    }

    public static List<Orbit> searchChildren(List<Orbit> searchSpace) {
        List<Orbit> children = new ArrayList<>();
        for (Orbit orbit: searchSpace) {
            for (Orbit child: orbit.getChildren(x -> !x.isVisited())) {
                children.add(child);
            }
        }
        return children;
    }

    public static List<Orbit> searchParents(List<Orbit> searchSpace) {
        List<Orbit> parents = new ArrayList<>();
        for (Orbit orbit: searchSpace) {
            Orbit parent = orbit.getParent();
            if (!parent.isVisited()) {
                parents.add(parent);
            }
        }
        return parents;
    }
}

