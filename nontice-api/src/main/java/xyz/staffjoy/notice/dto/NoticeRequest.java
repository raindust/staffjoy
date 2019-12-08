package xyz.staffjoy.notice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class NoticeRequest {

    @NotBlank(message = "Please provide an email")
    private String to;
    @NotBlank(message = "Please provide a subject")
    private String subject;
    @NotBlank(message = "Please provide a valid body")
    @JsonProperty("content")
    private String content;
    private String name;
}
