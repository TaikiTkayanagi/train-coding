package com.example.chapter4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem7 {
    private static class Project {
        private String value;
        private ArrayList<Project> from;
        private ArrayList<Project> to;

        public Project(String value) {
            this.value = value;
            this.from = new ArrayList<>();
            this.to = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        String[] projects = { "a", "b", "c", "d", "e", "f", "g", "h" };
        String[][] depends = { { "e", "a" }, { "b", "f" }, { "a", "b" }, { "a", "f" }, { "c", "f" }, { "g", "d" },
                { "h", "b" } };

        var memo = new HashMap<String, Project>();

        for (var project : projects) {
            memo.put(project, new Project(project));
        }

        for (var depend : depends) {
            var to = memo.get(depend[0]);
            var from = memo.get(depend[1]);
            memo.get(to.value).from.add(from);
            memo.get(from.value).to.add(to);
        }

        var queue = new ArrayDeque<Project>();
        for (var project : memo.values()) {
            if (project.from.isEmpty()) {
                queue.addLast(project);
            }
        }
        if (queue.isEmpty()) {
            System.out.println("例外");
        }

        var result = new ArrayList<Project>();
        while (!queue.isEmpty()) {
            var pop = queue.poll();
            for (var next : pop.to) {
                next.from.remove(pop);
                if (next.from.isEmpty()) {
                    queue.addLast(next);
                }
            }
            result.add(pop);
        }

        result.stream().forEach(v -> System.out.println(v.value));
    }
}
