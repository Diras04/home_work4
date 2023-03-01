package com.start.models;

import java.io.Serializable;

public enum ResourceType implements Serializable {
    URL("url"),
    VIDEO("video"),
    BOOK("book");
    private final String resourceType;

    ResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceType() {
        return resourceType;
    }


}
