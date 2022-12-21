package com.start.models;

public class AdditionalMaterials extends SuperObject{
   private ResourceType resourceType;
    public int lessonId;
    public static int idstatik = 1;

    public AdditionalMaterials(String name, int id, ResourceType resourceType) {
        super(name, idstatik);
        this.resourceType = resourceType;
        this.id = idstatik;
        this.lessonId = Lessons.idstatik;
        idstatik++;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getLessonId() {
        return lessonId;
    }
}
