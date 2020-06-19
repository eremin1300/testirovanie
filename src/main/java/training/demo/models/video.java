package training.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class video {

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

    private String theme;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String name) {
            this.theme = name;
        }

    private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    public video() {
    }

    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public video(String name, String title, String URL) {
        this.theme = theme;
        this.title = title;
        this.URL = URL;
    }

        }
