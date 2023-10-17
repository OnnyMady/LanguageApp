package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Sentence;
import proj.LanguageApp.Entity.Translation;

public class SentenceDTO {

    private Long id;

    private String sentence;

    private Long translationId;

    public SentenceDTO(Sentence sentence){
        this.id = sentence.getId();
        this.sentence = sentence.getSentence();
        this.translationId = sentence.getTranslation().getId();
    }

    public SentenceDTO(){

    }

    public Sentence toEntity(){
        Sentence entity = new Sentence();
        Translation translation = new Translation();
        translation.setId(this.getTranslationId());
        entity.setTranslation(translation);
        entity.setSentence(this.getSentence());
        entity.setId(this.getId());
        return entity;
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
