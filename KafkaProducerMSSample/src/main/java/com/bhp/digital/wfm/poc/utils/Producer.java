package com.bhp.digital.wfm.poc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Producer {
 @Value("${producer.propfile}")
 private	String propFile;
 private KafkaProducer<String, String> producer = null;
 private int GlobalCount=0;
 public Producer()
 {
//	 initialize();
//	 System.out.println("initialized producer");
 }
 //This method is used to send message using kafka . count denote number and strMessage 
 // is the message
 public String sendMessage(int count,String strMessage,String strTopic)
 {    
	 System.out.println("-----------------------------INSIDE----------");
	  //initialize();
	 try{
	 		for (int i=0;i<count;i++)
	 		{
	 			GlobalCount++;
	 			//ProducerRecord<String, String> pRecord = new ProducerRecord<String,String>(strTopic, strMessage+"--"+GlobalCount+"---");
	 		//	ProducerRecord<K,V> pRecord = new ProducerRecord<K,V>(strTopic, strMessage,strMessage+"--"+GlobalCount+"---");

	 			System.out.println("prepare to send to t topic::"+strTopic+"::");
	 			
	 			

	 			producer.send(new ProducerRecord<String,String>(strTopic, strMessage));
	 			producer.flush();
	 			System.out.println("Sending and flushingMessage to topic::"+strTopic+"::"+GlobalCount);

	 		}
	 		//producer.close();
 		}
 		catch(Exception ex)
 		{
 			ex.printStackTrace();
 			return "Error";
 		}
	 
	/* TestCallback callback = new TestCallback();
	 System.out.println("----------GLOBAL---------");
     ProducerRecord<String, String> data = new ProducerRecord<String, String>(
                 strTopic, strMessage, strMessage+"--"+GlobalCount+"---" );
         producer.send(data, callback);
         System.out.println("----------Message Sent---------");
     producer.close();*/

	 return "Success";
 }
 //Initialize
 
 @EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
 public void ContextRefreshedEvent() 
 {
	 initialize();
	System.out.println("Kafka producer initialized---::"+propFile);
 }

 private void initialize()
 {
     try (InputStream props = new FileInputStream(propFile)) 
     {
    	 Properties p = new Properties();
    	 p.load(props);
         producer = new KafkaProducer<String,String>(p);

     } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	 
 }
 
 private  class TestCallback implements Callback {
	    @Override
	    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
	        if (e != null) {
	            System.out.println("Error while producing message to topic :" + recordMetadata);
	            e.printStackTrace();
	        } else {
	            String message = String.format("sent message to topic:%s partition:%s  offset:%s", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
	            System.out.println(message);
	        }
	    }
	}
}
