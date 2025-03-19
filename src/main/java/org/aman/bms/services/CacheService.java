package org.aman.bms.services;


import org.springframework.stereotype.Service;

@Service
public interface CacheService {

    void set(String key, Object value);
    Object get(String key);
    void remove(String key);
    void getAllKeysAndValues();
    void deleteAll();
}
