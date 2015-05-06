package jba.model;

import jba.annotation.UniqueUsername;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Name must be at least 3 characters!")
    @Column(name = "name", unique = true)
    @UniqueUsername(message = "Such username already exists!")
    private String name;

    @Email(message = "Invalid email!")
    @Size(min = 1, message = "Invalid email!")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Size(min = 5, message = "Name must be at least 5 characters!")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Blog> blogs;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
