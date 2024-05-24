package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerLoopMain {
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
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String,String> producer=new KafkaProducer<>(config);
        for(int i=0;i<100;i++){
            ProducerRecord<String,String> record = new ProducerRecord<>("java",String.valueOf(i));
            producer.send(record);
            Thread.sleep(100);
        }
    }
}