package org.example;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.models.AIAnswerModel;
import org.example.services.AIAnswerService;
import org.example.services.HuggingFaceApiService;
import org.example.utils.MongoConnection;

import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        MongoCollection<Document> answers = MongoConnection.getCollection("answers");
        AIAnswerService answerService = new AIAnswerService(answers);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Zadaj mi pytanie");
        String prompt=scanner.nextLine();
        Map<String,String> result= HuggingFaceApiService.generate(prompt);
        answerService.createAiAnswer(result);


       // boolean document= answerService.deleteAiAnswer("67b755bac39f090157bc6dfe");
       // System.out.println(document);

       // Document document= answerService.getAiAnswer("67b7558e7f0b1931bf839337");
       // System.out.println(document);

        }
    }
