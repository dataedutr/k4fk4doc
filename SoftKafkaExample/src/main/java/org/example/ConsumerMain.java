package org.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerMain {
    public static void main(String[] args) throws InterruptedException {
         /*
        Kafka Producer
        1- Properties tanımlama (Hangi Kafka? Configurasyon nasıl olmalı (commit, offset, groupid vb) - Gerçek hayattaki; Adres,Pul
        2- Kafka Consumer oluşturulacak 1. sıradaki propertieslerle Gerçek Hayattaki : Zarf
        3- Kafka Consumer Records Kullanarak bir record almak için için ConsumerRecords Sınıfı kullanılır Gerçek hayattaki : Zarf içi (Mektup gibi)
         */
        Properties config=new Properties();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"80.240.17.24:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"teamjava104");
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest"); // Eğer earliest verilirse from-beginning gibi en baştan veri getirir
        //config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest"); // Eğer latest verilirse bağlandığın an itibariyle veri getirir

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(config);

        consumer.subscribe(Arrays.asList("softsecondtopic"));

        ConsumerRecords<String,String> records = consumer.poll(5000);

        for(ConsumerRecord<String,String> message:records){
            System.out.println("Topic: "+message.topic()+" Partition: "+message.partition());
            System.out.println("Value: "+message.value()+" Offset: "+message.offset());
        }

    }
}
