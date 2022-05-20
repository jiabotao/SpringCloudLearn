package org.example.elasticsearch.repository;

import org.example.elasticsearch.esentity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
