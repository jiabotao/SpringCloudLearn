package org.example.elasticsearch.repository;

import org.example.elasticsearch.esentity.Item;
import org.example.elasticsearch.esentity.UserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<UserEntity,Long> {
}
