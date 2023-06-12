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

    @Column(name = "SENTANCE")
    private String sentance;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "SOUND")
    private String sound;

    @Column(name = "LESSON")
    private String lesson;

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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSentance() {
        return sentance;
    }

    public void setSentance(String sentance) {
        this.sentance = sentance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
