package com.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TranslateRepository implements ITranslateRepository {
    private static Map<String, String> list = new HashMap<>();
    static {
        list.put("hello", "xin chào");
        list.put("sorry", "xin lỗi");
        list.put("six", "số 6");
        list.put("one", "số 1");
    }
    @Override
    public String result(String key) {
        return list.get(key);
    }
}
