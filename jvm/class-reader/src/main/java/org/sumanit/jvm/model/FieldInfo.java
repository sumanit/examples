package org.sumanit.jvm.model;

import org.sumanit.jvm.model.attribute.Attribute;

import java.util.Arrays;

public class FieldInfo {
    private Clazz clazz;

    private String accessFlags;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private Attribute[] attributeInfo;

    public String getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(String accessFlags) {
        this.accessFlags = accessFlags;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public Attribute[] getAttributeInfo() {
        return attributeInfo;
    }

    public void setAttributeInfo(Attribute[] attributeInfo) {
        this.attributeInfo = attributeInfo;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                ", accessFlags='" + accessFlags + '\'' +
                ", name=" + index2Str(nameIndex) +
                ", descriptor=" + index2Str(descriptorIndex) +
                ", attributesCount=" + attributesCount +
                ", attributeInfo=" + Arrays.toString(attributeInfo) +
                '}';
    }

    protected String index2Str(int index){
        return String.valueOf(clazz.getConstantPool()[index-1]);
    }
}
