package org.sumanit.jvm.model;

import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.model.constant.Constant;

import java.util.Map;

public class Clazz {
    private String magic;
    private short minorVersion;
    private short majorVersion;
    private short constantPoolCount;
    private Constant[] constantPool;
    private String accessFlags;
    private short thisClassIndex;
    private short superClassIndex;
    private short[] interfaceIndexs;
    private FieldInfo[] fieldInfos;
    private MethodInfo[] methodInfos;
    private Attribute[] attributeInfos;

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }


    public String getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(String accessFlags) {
        this.accessFlags = accessFlags;
    }

    public short getThisClassIndex() {
        return thisClassIndex;
    }

    public void setThisClassIndex(short thisClassIndex) {
        this.thisClassIndex = thisClassIndex;
    }

    public short getSuperClassIndex() {
        return superClassIndex;
    }

    public void setSuperClassIndex(short superClassIndex) {
        this.superClassIndex = superClassIndex;
    }

    public short[] getInterfaceIndexs() {
        return interfaceIndexs;
    }

    public void setInterfaceIndexs(short[] interfaceIndexs) {
        this.interfaceIndexs = interfaceIndexs;
    }

    public FieldInfo[] getFieldInfos() {
        return fieldInfos;
    }

    public void setFieldInfos(FieldInfo[] fieldInfos) {
        this.fieldInfos = fieldInfos;
    }

    public MethodInfo[] getMethodInfos() {
        return methodInfos;
    }

    public void setMethodInfos(MethodInfo[] methodInfos) {
        this.methodInfos = methodInfos;
    }

    public Constant[] getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(Constant[] constantPool) {
        this.constantPool = constantPool;
    }

    public Attribute[] getAttributeInfos() {
        return attributeInfos;
    }

    public void setAttributeInfos(Attribute[] attributeInfos) {
        this.attributeInfos = attributeInfos;
    }

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }
    public String index2Object(int index){
        return String.valueOf(constantPool[index-1]);
    }
}
