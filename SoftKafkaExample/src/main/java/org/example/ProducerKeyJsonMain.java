package org.example;

import io.confluent.kafka.serializers.KafkaJsonSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerKeyJsonMain {
    public static void main(String[] args) throws InterruptedException {
        /*
        Kafka Producer
        1- Properties tanımlama (Hangi Kafka? Configurasyon nasıl olmalı (acks,size vb) - Gerçek hayattaki; Adres,Pul
        2- Kafka Producer oluşturulacak 1. sıradaki propertieslerle Gerçek Hayattaki : Zarf
        3- Kafka Producer Kullanarak bir record göndermek için ProducerRecord Sınıfı kullanılır Gerçek hayattaki : Zarf içi (Mektup gibi)
         */
        Properties config=new Properties();
        //config.put("bootstrap.servers","80.240.17.24:9092");
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"80.240.17.24:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        Account a1 = new Account(123,"Talha Kilic","ayakkabi");

        KafkaProducer<String,Account> producer=new KafkaProducer<>(config);

        ProducerRecord<String,Account> record = new ProducerRecord<>("search",String.valueOf(a1.getCustomerId()%3),a1);

        producer.send(record);

        producer.flush();

    }
}