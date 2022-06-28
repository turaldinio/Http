import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Cat  {
    private String id;
    private String text;
    private String type;
    private String user;
    private String upvote;


    public Cat(
            @JsonProperty("id") String id,
            @JsonProperty("test") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") String upvote
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvote = upvote;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getUpvote() {
        return upvote;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user='" + user + '\'' +
                ", upvote=" + upvote +
                '}';
    }
}
