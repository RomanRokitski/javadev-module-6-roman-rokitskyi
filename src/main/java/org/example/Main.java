package org.example;


import org.example.conf.FlywayConfigurations;
import org.example.crud.Client;
import org.example.crud.ClientService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

//        new FlywayConfigurations()
//                .setup()
//                .migrate();

        ClientService clientService = new ClientService();
        System.out.println("clientService.listAll() = " + clientService.listAll());
        clientService.deleteByID(4);
        System.out.println("clientService.listAll() = " + clientService.listAll());

    }
}
