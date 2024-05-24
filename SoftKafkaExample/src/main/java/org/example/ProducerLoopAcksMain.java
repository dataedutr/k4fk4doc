package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerLoopAcksMain {
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
        //config.put(ProducerConfig.ACKS_CONFIG,"0"); Eğer Acks=0'sa producer kafkaya veriyi gönderir ve alındı cevabını beklemez. Çok hızlı gönderim olur fakat message kaybetme riski var
        //config.put(ProducerConfig.ACKS_CONFIG,"1"); //Eğer Acks=1'se producer kafkaya veriyi gönderir ve Leader Partition'a yazılana kadar bekler. Bir response ister
        config.put(ProducerConfig.ACKS_CONFIG,"all"); // Eğer acks=All ya da acks=-1 yazılırsa tüm replication partitionlara yazılana kadar bekler. Yavaştır ama message kaybolma ihtimali yok

        KafkaProducer<String,String> producer=new KafkaProducer<>(config);
        for(int i=0;i<1000;i++){
            ProducerRecord<String,String> record = new ProducerRecord<>("ackstest2",String.valueOf(i));
            Future<RecordMetadata> send = producer.send(record);
            producer.flush();

        }
    }
}