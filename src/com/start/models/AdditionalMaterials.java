package com.start.models;

import java.util.Comparator;

public class AdditionalMaterials extends SuperObject{
    private ResourceType resourceType;
    public int lessonId;
    public static int idstatik = 1;

    public AdditionalMaterials(String name, int id, ResourceType resourceType, int lessonId) {
        super(name, idstatik);
        this.resourceType = resourceType;
        this.id = idstatik;
        this.lessonId = lessonId;
        idstatik++;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getLessonId() {
        return lessonId;
    }

    public static Comparator<AdditionalMaterials> amComparatorId = new Comparator<AdditionalMaterials>() {

        public int compare(AdditionalMaterials c1, AdditionalMaterials c2) {
            int aMName1 = c1.getId();
            int amName2 = c2.getId();


            return aMName1 - amName2;


        }
    };
    public static Comparator<AdditionalMaterials> amComparatorIdLesson = new Comparator<AdditionalMaterials>() {

        public int compare(AdditionalMaterials c1, AdditionalMaterials c2) {
            int aMName1 = c1.getLessonId();
            int amName2 = c2.getLessonId();


            return aMName1 - amName2;


        }
    };
    public static Comparator<AdditionalMaterials> amComparatorIdType = new Comparator<AdditionalMaterials>() {

        public int compare(AdditionalMaterials c1, AdditionalMaterials c2) {
            int aMName1 = c1.getResourceType().ordinal();
            int amName2 = c2.getResourceType().ordinal();


            return amName2 - aMName1;


        }
    };


}
