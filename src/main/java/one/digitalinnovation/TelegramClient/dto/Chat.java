package one.digitalinnovation.TelegramClient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Chat {

    private Long id;
    private String type;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastname;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}