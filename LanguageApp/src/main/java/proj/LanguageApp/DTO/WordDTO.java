package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Word;
import java.io.File;

public class WordDTO {

    private Integer id;

    private String name;

    private String category;

    private String sentence;

    private String translation;

    private String soundName;

    private String pictureName;
    private byte[] fileBytes;

    private String lesson;

    private File file;

    private byte[] pictureBytes;

    public WordDTO (Word word){
        this.id = word.getId();
        this.category = word.getCategory();
        this.name = word.getName();
        this.translation = word.getTranslation();
        this.sentence = word.getSentence();
        this.soundName = word.getSoundName();
        this.pictureName = word.getPictureName();
        this.lesson = word.getLesson();
        this.fileBytes = word.getFileBytes();
        this.pictureBytes = word.getPictureBytes();
    }

    public WordDTO (String name,String category, String sentence, String translation,String lesson){
        this.category = category;
        this.name = name;
        this.translation = translation;
        this.sentence = sentence;
        this.lesson = lesson;
    }

    public WordDTO (){

    }

    public Word toEntity () {
        Word entity = new Word();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCategory(this.getCategory());
        entity.setTranslation(this.getTranslation());
        entity.setSoundName(this.getSoundName());
        entity.setSentence(this.getSentence());
        entity.setLesson(this.getLesson());
        entity.setPictureName(this.pictureName);
        entity.setFileBytes(this.fileBytes);
        entity.setPictureBytes(this.pictureBytes);
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

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public byte[] getPictureBytes() {
        return pictureBytes;
    }

    public void setPictureBytes(byte[] pictureBytes) {
        this.pictureBytes = pictureBytes;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
}
