package org.example.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.models.AIAnswerModel;

import java.util.Map;

public class AIAnswerService {


    private MongoCollection<Document> answers;
    public AIAnswerService(MongoCollection<Document> answers){
    this.answers=answers;
    }


    public void createAiAnswer(Map<String,String> model) {
        try {
            AIAnswerModel answerData = new AIAnswerModel(
                    model.get("content"),
                    model.get("timestamp"));

            Document doc = new Document("content", answerData.getContent())
                    .append("timestamp", answerData.getTimestamp());
            this.answers.insertOne(doc);
            System.out.println("Dodano odpowiedz AI");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Document getAiAnswer(String id) {
        try {
            return answers.find(new Document("_id", new ObjectId(id))).first();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean deleteAiAnswer(String id) {
        try {
            var result = answers.deleteOne(new Document("_id", new ObjectId(id)));
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
