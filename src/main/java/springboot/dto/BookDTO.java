package springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("Book Model")
public class BookDTO {


    @JsonProperty("author")
    @NotNull(message = "Field 'author' is required.")
    @NotEmpty(message = "Field 'author' cannot be empty.")
    private String author;

    @JsonProperty("title")
    @NotNull(message = "Field 'title' is required.")
    @NotEmpty(message = "Field 'title' cannot be empty.")
    private String title;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
