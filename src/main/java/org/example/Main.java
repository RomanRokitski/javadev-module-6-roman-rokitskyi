package org.example;

import org.example.conf.FlywayConfigurations;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        new FlywayConfigurations()
                .setup()
                .migrate();
    }
}
