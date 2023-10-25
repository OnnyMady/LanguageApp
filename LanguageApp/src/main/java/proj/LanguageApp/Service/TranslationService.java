package proj.LanguageApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.LanguageApp.DTO.SentenceDTO;
import proj.LanguageApp.DTO.TranslationDTO;
import proj.LanguageApp.Entity.Sentence;
import proj.LanguageApp.Entity.Translation;
import proj.LanguageApp.Repository.SentenceRepository;
import proj.LanguageApp.Repository.TranslationRepository;
import proj.LanguageApp.Repository.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private WordRepository wordRepository;

    @Transactional
    public TranslationDTO addTranslation(Long wordId, String translationName, String sentenceName) {

        Sentence sentence = new Sentence();
        Translation translation = new Translation();

        translation.setWord(wordRepository.findById(wordId).get());
        translation.setName(translationName);
        TranslationDTO translationDTO = new TranslationDTO(translationRepository.save(translation));
        List<SentenceDTO> sentenceList = new ArrayList<>();

        sentence.setSentence(sentenceName);
        sentence.setTranslation(translation);
        sentenceList.add(new SentenceDTO(sentenceRepository.save(sentence)));
        translationDTO.setSentenceDTOList(sentenceList);

        return translationDTO;

    }

    @Transactional
    public void delete(Long translationId){
        TranslationDTO translationDTO = new TranslationDTO(translationRepository.getById(translationId));
        for(SentenceDTO sentence: translationDTO.getSentenceDTOList()){
            sentenceRepository.deleteSentenceById(sentence.getId());
        }

        translationRepository.deleteTranslationById(translationId);
    }

    @Transactional
    public void deleteSentence(Long sentenceId){

        sentenceRepository.deleteSentenceById(sentenceId);
    }

    @Transactional
    public SentenceDTO addSentence(SentenceDTO sentenceDTO){
        return new SentenceDTO(sentenceRepository.save(sentenceDTO.toEntity()));
    }

    @Transactional
    public SentenceDTO editSentence(SentenceDTO sentenceDTO){
        SentenceDTO editSentence = new SentenceDTO(sentenceRepository.findById(sentenceDTO.getId()).get());
        editSentence.setSentence(sentenceDTO.getSentence());
        return new SentenceDTO(sentenceRepository.save(editSentence.toEntity()));
    }

    @Transactional
    public TranslationDTO editTranslation(TranslationDTO translationDTO){
        TranslationDTO editTranslation = new TranslationDTO(translationRepository.findById(translationDTO.getId()).get());
        editTranslation.setName(translationDTO.getName());
        return new TranslationDTO(translationRepository.save(editTranslation.toEntity()));
    }

}
