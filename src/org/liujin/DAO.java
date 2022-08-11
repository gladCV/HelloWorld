package org.liujin;

import java.util.*;

/**
 * @author LiuJin
 * @date 2022-08-09 15:15
 */
public class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public T get(String id) {
        return map.get(id);
    }
    public void update(String id, T entity) {
        if (map.containsKey(id))
            map.put(id, entity);
    }
    public List<T> list() {
        //return (List<T>) map.values();
        return new ArrayList<>(map.values());
    }
    public void delete(String id) {
        map.remove(id);
    }
}
