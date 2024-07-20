package com.abdul.projects.urlshortener.model;

import lombok.*;


@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UrlRequest {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
