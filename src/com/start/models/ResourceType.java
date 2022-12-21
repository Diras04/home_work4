package com.start.models;

public enum ResourceType {
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
