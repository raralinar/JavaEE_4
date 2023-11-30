package task5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import task3.MusicEntity;

import java.util.List;

public class ModelMusic {
    static EntityManager entityManagerMusic = Persistence.createEntityManagerFactory("musicPU").createEntityManager();

    public static List<MusicEntity> filter(String singer) {
        return entityManagerMusic.createQuery("select m from MusicEntity m where m.singer = '" + singer +"'").getResultList();
    }

    public static List<MusicEntity> getAll() {
        return entityManagerMusic.createQuery("select m from MusicEntity m").getResultList();
    }

    public static void addMusic(String singer, String title, String genre) {
        if (!singer.isBlank() && !title.isBlank() && !genre.isBlank()) {
            MusicEntity m = new MusicEntity(singer, title, genre);
            entityManagerMusic.getTransaction().begin();
            entityManagerMusic.persist(m);
            entityManagerMusic.getTransaction().commit();
        }
    }

    public static void delete(String id) {
        MusicEntity m = entityManagerMusic.find(MusicEntity.class, Integer.parseInt(id));
        if (m != null) {
            entityManagerMusic.getTransaction().begin();
            entityManagerMusic.remove(m);
            entityManagerMusic.getTransaction().commit();
        }
    }
}
