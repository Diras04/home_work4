package com.start.models;

import java.io.Serializable;

public class AdditionalMaterials extends SuperObject implements Serializable {
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


    @Override
    public String toString() {
        return "AdditionalMaterials{" +
                "resourceType=" + resourceType +
                ", lessonId=" + lessonId +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
