package org.acme;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        System.out.println("Running main method");

        Config config = new Config();
        config.useSingleServer().setAddress(String.format("redis://%s", "localhost:6379"));
        RedissonClient redisson = Redisson.create(config);

        redisson.getMap("mapName");

        redisson.shutdown();

        Quarkus.run(args);
    }
}
