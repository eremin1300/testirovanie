package training.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class lesson {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getThem() {
        return theme;
    }

    public void setThem(String name) {
        this.theme = theme;
    }

    private String theme;

    public lesson() {
    }

    public lesson(String theme, String title, String fullText) {
        this.theme = theme;
        this.title = title;
        this.fullText = fullText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    private String title;
    private String fullText;
}
