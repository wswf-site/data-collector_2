package com.example.data_collector.repository;

import com.example.data_collector.entity.YoutubeLike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YoutubeLikeRepository extends MongoRepository<YoutubeLike, String> {
}
