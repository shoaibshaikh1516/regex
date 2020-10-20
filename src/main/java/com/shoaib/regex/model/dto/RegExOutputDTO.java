package com.shoaib.regex.model.dto;

public class RegExOutputDTO {
    String match;
    boolean error;

    public RegExOutputDTO() {
    }

    public RegExOutputDTO(String match, boolean error) {
        this.match = match;
        this.error = error;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}

