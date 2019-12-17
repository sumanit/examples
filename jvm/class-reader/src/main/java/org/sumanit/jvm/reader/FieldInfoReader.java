package org.sumanit.jvm.reader;


import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.FieldInfo;
import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.reader.attribute.AttributeReader;

import java.nio.ByteBuffer;

public class FieldInfoReader {
    private AttributeReader attributeReader = new AttributeReader();
    public FieldInfo read(ByteBuffer buf, Clazz clazz){
        FieldInfo fieldInfo = new FieldInfo();
        String accessFlags = ByteBufferReaderUtil.readHexStr(buf,2);
        fieldInfo.setAccessFlags(accessFlags);
        short nameIndex = ByteBufferReaderUtil.readShort(buf);
        fieldInfo.setNameIndex(nameIndex);
        short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
        fieldInfo.setDescriptorIndex(descriptorIndex);
        short attributesCount = ByteBufferReaderUtil.readShort(buf);
        fieldInfo.setAttributesCount(attributesCount);
        Attribute[] attributeInfo = new Attribute[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            Attribute attribute = attributeReader.read(buf,clazz);
            attributeInfo[i] = attribute;
        }
        fieldInfo.setAttributeInfo(attributeInfo);
        return fieldInfo;
    }
}
