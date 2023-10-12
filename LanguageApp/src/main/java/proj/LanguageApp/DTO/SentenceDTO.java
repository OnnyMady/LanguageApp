package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Sentence;

public class SentenceDTO {

    private Long id;

    private String sentence;

    private Long translationId;

    SentenceDTO(Sentence sentence){
        this.id = sentence.getId();
        this.sentence = sentence.getSentence();
        this.translationId = sentence.getTranslation().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Long getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Long translationId) {
        this.translationId = translationId;
    }
}
