package proj.LanguageApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.LanguageApp.Entity.Translation;

public interface TranslationRepository extends JpaRepository<Translation, Long> {

    @Modifying
    @Query("delete from Translation where id = :id")
    void deleteTranslationById(@Param("id") Long id);

}
