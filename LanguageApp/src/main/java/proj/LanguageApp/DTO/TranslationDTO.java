package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Sentence;
import proj.LanguageApp.Entity.Translation;
import proj.LanguageApp.Entity.Word;
import java.util.ArrayList;
import java.util.List;

public class TranslationDTO {

    private Long id;

    private String name;

    private List<SentenceDTO> sentenceDTOList;

    private Long wordId;

    public TranslationDTO(Translation translation){
        this.id = translation.getId();
        this.name = translation.getName();
        this.wordId = translation.getWord().getId();

        if(translation.getSentenceList() != null){
            List<SentenceDTO> myList = new ArrayList<>();
            for(Sentence mySentance: translation.getSentenceList()){
                myList.add(new SentenceDTO(mySentance));
            }
            this.sentenceDTOList = myList;
        }

    }

    public Translation toEntity () {
        Translation entity = new Translation();
        entity.setId(this.getId());
        entity.setName(this.getName());

        Word word = new Word();
        word.setId(this.getWordId());
        entity.setWord(word);

        return entity;
    }

    public TranslationDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SentenceDTO> getSentenceDTOList() {
        return sentenceDTOList;
    }

    public void setSentenceDTOList(List<SentenceDTO> sentenceDTOList) {
        this.sentenceDTOList = sentenceDTOList;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }
}
