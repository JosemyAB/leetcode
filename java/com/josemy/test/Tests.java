import api.GitLabClient;
import api.Namespace;
import api.Project;

import java.awt.*;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tests {

    public static void main(String[] args) {

//        testArrays();
        testSort();
    }

    private static void testSort() {
        List<Project> projects = new ArrayList<>();

        projects.add(newProject("Alpha", 1));
        projects.add(newProject("beta", 2));
        projects.add(newProject("Gamma", 1));
        projects.add(newProject("DELTA", 1));

        // Sort by name
        System.out.println("TEST SORTED BY NAME");
        List<Project> sorted = GitLabClient.orderByName(projects);
        sorted.forEach(project -> System.out.println(project.name));

        //GROUP BY NAMESPACE
        System.out.println("TEST GROUPED BY NAMESPACE");
        Map<Integer, List<Project>> grouped = GitLabClient.grooupByNamespace(projects);
        grouped.forEach((nsId, projs) -> {
            System.out.println("::: Namespace " + nsId);
            projs.forEach(project -> System.out.println("    - " + project.name));
        });

    }

    private static Project newProject(String name, Integer id) {
        Project project = new Project();
        project.name = name;
        project.namespace = new Namespace();
        project.namespace.id = id;
        project.namespace.name = name + "NS";

        return project;
    }

    private static void testArrays() {
        //Questions 1. Missing elements
        System.out.println("=== Question 1 & 2: Find Missing Element ===\n");

        int[] testArray1 = {0, 1, 2, 3, 4, 6, 7, 8, 9};  // Missing: 5
        int[] testArray2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};  // Missing: 9
        int[] testArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // Missing: 0

        System.out.println("Test 1 - Missing 5:");
        System.out.println("  Linear: " + MissingElement.findMissing(testArray1));
        System.out.println("  Binary: " + MissingElement.findMissingBinarySearch(testArray1));
        System.out.println("  Math:   " + MissingElement.findMissingMath(testArray1));

        System.out.println("Test 2 - Missing 9:");
        System.out.println("  Linear: " + MissingElement.findMissing(testArray2));
        System.out.println("  Binary: " + MissingElement.findMissingBinarySearch(testArray2));
        System.out.println("  Math:   " + MissingElement.findMissingMath(testArray2));

        System.out.println("Test 3 - Missing 0:");
        System.out.println("  Linear: " + MissingElement.findMissing(testArray3));
        System.out.println("  Binary: " + MissingElement.findMissingBinarySearch(testArray3));
        System.out.println("  Math:   " + MissingElement.findMissingMath(testArray3));
    }
}
