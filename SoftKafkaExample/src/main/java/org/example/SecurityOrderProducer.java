package org.example;

import io.confluent.kafka.serializers.KafkaJsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class SecurityOrderProducer {
    public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException {

        Properties config=new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"66.228.62.12:9093");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        config.put("security.protocol", "SSL");
        config.put("ssl.truststore.location", "/Users/talhaklc/Desktop/keystore_kafka/kafka.broker1.truststore.jks");
        config.put("ssl.truststore.password", "123123");
        config.put("ssl.keystore.location", "/Users/talhaklc/Desktop/keystore_kafka/kafka.broker1.keystore.jks");
        config.put("ssl.keystore.password", "123123");
        config.put("ssl.key.password", "123123");
        config.put("ssl.endpoint.identification.algorithm", "");

        KafkaProducer<String,Order> producer=new KafkaProducer<>(config);

        List<String> lines = Files.readAllLines(Paths.get(SecurityOrderProducer.class.getClassLoader().getResource("salesdata.csv").toURI()));

        for(int i=1;i<lines.size();i++){
            String line = lines.get(i);
            String[] values = line.split(",");
            Order o1=new Order(values[1],values[2],values[3],Integer.parseInt(values[4]),Double.valueOf(values[5]),values[0]);

            ProducerRecord<String,Order> record = new ProducerRecord<>("order_test",null,o1);
            producer.send(record);
            producer.flush();
            System.out.println(o1.toString());
            Thread.sleep(1000);
        }
    }
}