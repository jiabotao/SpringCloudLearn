package org.example.elasticsearch.service;

import co.elastic.clients.elasticsearch.security.User;
import org.example.elasticsearch.esentity.Item;
import org.example.elasticsearch.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public long count(){
        long count = itemRepository.count();
        return count;
    }
    public void saveDriver(Item item) {
        itemRepository.save(item);
    }

}
