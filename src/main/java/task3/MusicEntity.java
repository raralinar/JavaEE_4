package task3;

import jakarta.persistence.*;

@Entity
@Table(name="MUSIC")
public class MusicEntity {
    private Long music_id;
    private String singer, title, genre;

    public MusicEntity() {}

    public MusicEntity(String singer, String title, String genre) {
        this.singer = singer;
        this.title = title;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getMusic_id() { return music_id; }
    public void setMusic_id(Long music_id) { this.music_id = music_id; }
}
