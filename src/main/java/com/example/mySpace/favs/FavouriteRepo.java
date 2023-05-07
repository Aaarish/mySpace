package com.example.mySpace.favs;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepo extends MongoRepository<FavouriteEntity, String> {
}
