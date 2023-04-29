package org.example.databaseUtils;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        System.out.println("databaseQueryService.findLongestProjects() = " + databaseQueryService.findLongestProjects());
        System.out.println("databaseQueryService.findMaxProjectsClients() = " + databaseQueryService.findMaxProjectsClients());
        System.out.println("databaseQueryService.findMaxSalaryWorkers() = " + databaseQueryService.findMaxSalaryWorkers());
        System.out.println("databaseQueryService.findYoungestEldestWorkers() = " + databaseQueryService.findYoungestEldestWorkers());
        System.out.println("databaseQueryService.printProjectPrices() = " + databaseQueryService.printProjectPrices());
    }
}
