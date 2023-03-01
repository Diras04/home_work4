package com.start.service;

import com.start.models.AdditionalMaterials;

import java.util.Map;

public class AdditionalMaterialsService {
    public void printAmArray(Map<Integer, AdditionalMaterials> amArray) {

        for (Map.Entry<Integer, AdditionalMaterials> n : amArray.entrySet()) {

            System.out.println("Id - " + (n.getValue()).getId() + "; Name - " + (n.getValue()).getName()
                    + "; Type - " + (n.getValue()).getResourceType() +
                    "; Lesso ID - " + (n.getValue()).getLessonId());

        }
    }

}
