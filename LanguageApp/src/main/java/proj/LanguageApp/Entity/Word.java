package proj.LanguageApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TRANSLATION")
    private String translation;

    @Column(name = "SENTENCE")
    private String sentence;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SOUNDNAME")
    private String soundName;

    @Column(name = "LESSON")
    private String lesson;

    @Column(name = "PICTURENAME")
    private String pictureName;

    @Column(name = "fileBytes")
    private byte[] fileBytes;

    @Column(name="PICTURE")
    private byte[] pictureBytes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public byte[] getPictureBytes(){
        return pictureBytes;
    }

    public void setPictureBytes(byte[] pictureBytes){
        this.pictureBytes = pictureBytes;
    }
}
