package com.shoaib.regex.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class RegExInputDTO {
    String regex;
    String extBody;

    public RegExInputDTO(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getExtBody() {
        return extBody;
    }

    public void setExtBody(String extBody) {
        this.extBody = extBody;
    }
}