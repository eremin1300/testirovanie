package training.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class themes {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public themes() {
    }

    public String getName() {
        return name;
    }

    public themes(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}

/*@Entity
@Table(name = "Users")
public class User implements UserDetails {
    @Id
       private String username;

       @Column(nullable = false)
       private String password;

       private boolean enabled;
       private boolean accountNonExpired;
       private boolean accountNonLocked;
       private boolean credentialsNonExpired;
       private String companyName;
       private String email;

       @ElementCollection(fetch=FetchType.EAGER)
       @CollectionTable(name="Authorities", joinColumns=@JoinColumn(name="username"))
       @Column(name="authority")
       private Set<String> roles = new HashSet<String>();

       @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
       @JoinColumn(name = "institutionId", nullable = false)
       private Institution institution;
... getters & setters
}*/


/*@Entity
@Table(name = "Institution")
public class Institution {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long institutionId;
       private String name;

       @OneToMany(mappedBy = "institution", fetch = FetchType.EAGER)
       @Fetch(value = FetchMode.SUBSELECT)
       List<User> users = new ArrayList<User>();
       ... getters & setters
}*/