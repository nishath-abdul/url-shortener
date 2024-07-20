package com.abdul.projects.urlshortener.service;

import com.abdul.projects.urlshortener.entity.Url;
import com.abdul.projects.urlshortener.repository.UrlShortenerRepository;
import com.abdul.projects.urlshortener.util.MD5Utils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

@Service
public class UrlService {

    private final UrlShortenerRepository urlShortenerRepository;

    private final BaseConversion baseConversion;

    private final MD5Utils md5Utils;

    public UrlService(UrlShortenerRepository urlShortenerRepository, BaseConversion baseConversion, MD5Utils md5Utils) {
        this.urlShortenerRepository = urlShortenerRepository;
        this.baseConversion = baseConversion;
        this.md5Utils = md5Utils;
    }

    public String getShortenedUrl(String url){
        var urlData = new Url();
        var timeStamp = System.currentTimeMillis();
        urlData.setUrl(url);
        urlData.setCreatedDate(new Date(timeStamp));
        urlData.setExpiresDate(new Date(timeStamp + TimeUnit.MINUTES.toMillis(5)));

        var urlRecord = urlShortenerRepository.save(urlData);
        return MD5Utils.generateRandomShortUrl(url);
       // return md5Utils.
       // return baseConversion.encode(urlRecord.getId());
    }

}
