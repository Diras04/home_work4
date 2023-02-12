package com.start.repository;

import com.start.models.AdditionalMaterials;
import com.start.models.LogEnum;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class AdditionalMaterialsRepositoryMapa {
    private List<AdditionalMaterials> list;
    private Map<Integer, List<AdditionalMaterials>> map;


    public AdditionalMaterialsRepositoryMapa() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();

    }

    public void add(AdditionalMaterials additionalMaterials) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "add", LocalDateTime.now());

        List<AdditionalMaterials> list1;
        if (map.get(additionalMaterials.getLessonId()) == null) {
            List<AdditionalMaterials> list2 = new ArrayList<>();
            list2.add(additionalMaterials);
            map.put(additionalMaterials.lessonId, list2);
        }
        else {
            list1 = map.get(additionalMaterials.getLessonId());
            list1.add(additionalMaterials);
            map.put(additionalMaterials.lessonId, list1);
        }
    }

    public List<AdditionalMaterials> getByLessonsID(Integer k) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "get", LocalDateTime.now());
        return map.get(k);

    }

    public Map<Integer, List<AdditionalMaterials>> getAll() {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "getAll", LocalDateTime.now());
        return map;
    }

    public AdditionalMaterials getById(Integer i) {
        LogRepository.getInstance().createLog("RepositoryServiceMapa", LogEnum.INFO,
                "getById", LocalDateTime.now());
        return (AdditionalMaterials) map.values().stream().flatMap(p -> p.stream()).filter(p -> p.getId() == i);
    }


}
