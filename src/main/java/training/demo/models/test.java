package training.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class test {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getTheme() {
        return theme;
    }

    public test() {
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public test(String theme, String title, String fullText) {
        this.theme = theme;
        this.title = title;
        this.fullText = fullText;
    }

    private String theme;

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
