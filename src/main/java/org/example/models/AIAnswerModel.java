package org.example.models;

public class AIAnswerModel {
    private  String content;
    private  String timestamp;


    public AIAnswerModel() {
    }

    public AIAnswerModel(String content, String timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AIAnswerModel{" +
                "content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
