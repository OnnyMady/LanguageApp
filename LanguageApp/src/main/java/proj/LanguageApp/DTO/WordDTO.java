package proj.LanguageApp.DTO;

import proj.LanguageApp.Entity.Translation;
import proj.LanguageApp.Entity.Word;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WordDTO {

    private Long id;

    private String name;

    private String category;

    private String soundName;

    private String pictureName;

    private String lesson;

    private List<TranslationDTO> translationDTOList;

    public WordDTO (Word word){
        this.id = word.getId();
        this.category = word.getCategory();
        this.name = word.getName();
        this.soundName = word.getSoundName();
        this.pictureName = word.getPictureName();
        this.lesson = word.getLesson();

        List<TranslationDTO> myList = new ArrayList<>();
        if(word.getTranslationList() != null){
            for(Translation myTranslation: word.getTranslationList()){
                myList.add(new TranslationDTO(myTranslation));
            }
            this.translationDTOList = myList;
        }

    }

    public WordDTO (String name,String category){
        this.category = category;
        this.name = name;
    }

    public WordDTO (){

    }

    public Word toEntity () {
        Word entity = new Word();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCategory(this.getCategory());
        entity.setSoundName(this.getSoundName());
        entity.setLesson(this.getLesson());
        entity.setPictureName(this.getPictureName());
//        entity.setTranslationList(this.getTranslationList());
        return entity;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public List<TranslationDTO> getTranslationDTOList() {
        return translationDTOList;
    }

    public void setTranslationDTOList(List<TranslationDTO> translationDTOList) {
        this.translationDTOList = translationDTOList;
    }
}
