package proj.LanguageApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sentence")
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sentence")
    private String sentence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "translation_id")
    private Translation translation;

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

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }
}
