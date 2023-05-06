package org.example.conf;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

public class FlywayConfigurations {

    Database database;
    private Flyway flyway;
    public void setup() {
        Location migration = new Location("db/migration");
        Location mixture = new Location("db/mixture");
        flyway = Flyway.configure().
                encoding(StandardCharsets.UTF_8).
                locations(migration, mixture).
                dataSource((DataSource) database.getConnection())
                .load();
    }

    public void migrate() {
        flyway.migrate();
    }


}

