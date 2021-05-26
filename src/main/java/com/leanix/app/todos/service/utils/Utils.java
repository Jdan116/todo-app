package com.leanix.app.todos.service.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;

@Service
public class Utils {

    @Autowired
    Gson gson;

    public <T> Iterable<T> isSafeList(Iterable<T> iterable) {
        if (iterable != null) {
            Iterator<T> iterator = iterable.iterator();
            if (iterator.hasNext() && iterator.next() == null) {
                iterator.remove();
            }
            return iterable;
        }
        return Collections.emptyList();
    }


    /**
     * convert object to json string
     * @param o
     * @return
     */
    public String toJson(Object o) {
        return gson.toJson(o);
    }

}
