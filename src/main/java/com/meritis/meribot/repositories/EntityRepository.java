package com.meritis.meribot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meritis.meribot.models.Entity;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {

}
