package proj.LanguageApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.LanguageApp.Entity.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {

    @Modifying
    @Query("delete from Sentence where id = :id")
    void deleteSentenceById(@Param("id") Long id);
}
