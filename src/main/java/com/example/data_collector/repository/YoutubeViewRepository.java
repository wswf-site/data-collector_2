package com.example.data_collector.repository;

import com.example.data_collector.entity.YoutubeView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoutubeViewRepository extends MongoRepository<YoutubeView, String> {
}
