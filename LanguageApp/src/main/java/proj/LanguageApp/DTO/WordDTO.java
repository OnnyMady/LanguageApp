package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Word;

import java.util.SplittableRandom;

public class WordDTO {

    private Integer id;

    private String name;

    private String category;

    private String sentance;

    private String translation;

    private String sound;

    private String lesson;

    public WordDTO (Word word){
        this.id = word.getId();
        this.category = word.getCategory();
        this.name = word.getName();
        this.translation = word.getTranslation();
        this.sentance = word.getSentance();
        this.sound = word.getSound();
        this.lesson = word.getLesson();
    }

    public Word toEntity () {
        Word entity = new Word();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCategory(this.getCategory());
        entity.setTranslation(this.getTranslation());
        entity.setSound(this.getSound());
        entity.setSentance(this.getSentance());
        entity.setLesson(this.getLesson());
        return entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSentance() {
        return sentance;
    }

    public void setSentance(String sentance) {
        this.sentance = sentance;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}
