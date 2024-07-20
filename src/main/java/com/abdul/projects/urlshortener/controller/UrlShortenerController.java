package com.abdul.projects.urlshortener.controller;

import com.abdul.projects.urlshortener.model.UrlRequest;
import com.abdul.projects.urlshortener.service.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UrlShortenerController {

    private final UrlService urlService;

    public UrlShortenerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "url/shortener")
    public ResponseEntity<String> getShortenedUrl(@RequestBody UrlRequest request){
        var response = urlService.getShortenedUrl(request.getUrl());
        return ResponseEntity.ok(response);

    }
}
