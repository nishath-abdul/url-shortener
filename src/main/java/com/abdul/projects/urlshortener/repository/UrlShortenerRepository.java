package com.abdul.projects.urlshortener.repository;

import com.abdul.projects.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortenerRepository extends JpaRepository<Url, Long> {
}
