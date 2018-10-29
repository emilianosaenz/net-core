/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.none.redis.lettuce.client;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.apache.log4j.Logger;

/**
 *
 * @author esaenz
 */
public class Main {
    
    final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringCommands sync = connection.sync();
        String value = sync.get("key").toString();
        LOGGER.info("VALUE: "+value);
    }

}
