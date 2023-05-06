package org.example.conf;

public class Main {
    public static void main(String[] args) {
        FlywayConfigurations flywayConfigurations = new FlywayConfigurations();

        flywayConfigurations.setup();
        flywayConfigurations.migrate();
    }
}
