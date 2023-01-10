package com.start.service;

import com.start.models.AdditionalMaterials;
import com.start.models.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdditionalMaterialsService {
    public void printAmArray(List<AdditionalMaterials> amArray) {
        Collections.sort(amArray, AdditionalMaterials.amComparatorId);
        for (AdditionalMaterials n : amArray) {

            System.out.println("Id - " + ((AdditionalMaterials) n).getId() + "; Type - " + ((AdditionalMaterials) n).getResourceType() +
                    "; Lesso ID - " + ((AdditionalMaterials) n).getLessonId());

        }
    }
    public void printAmArrayByLessonId(List<AdditionalMaterials> amArray) {
        Collections.sort(amArray, AdditionalMaterials.amComparatorIdLesson);
        for (AdditionalMaterials n : amArray) {

            System.out.println("Id - " + ((AdditionalMaterials) n).getId() + "; Type - " + ((AdditionalMaterials) n).getResourceType() +
                    "; Lesso ID - " + ((AdditionalMaterials) n).getLessonId());

        }
    }
    public void printAmArrayByType(List<AdditionalMaterials> amArray) {
        Collections.sort(amArray, AdditionalMaterials.amComparatorIdType);
        for (AdditionalMaterials n : amArray) {

            System.out.println("Id - " + ((AdditionalMaterials) n).getId() + "; Name - " +((AdditionalMaterials) n).getName()
                    + "; Type - " + ((AdditionalMaterials) n).getResourceType() +
                    "; Lesson ID - " + ((AdditionalMaterials) n).getLessonId());

        }
    }
}
