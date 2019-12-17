package org.sumanit.jvm.reader;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.MethodInfo;
import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.reader.attribute.AttributeReader;

import java.nio.ByteBuffer;

public class MethodInfoReader {
    private AttributeReader attributeReader = new AttributeReader();
    public MethodInfo read(ByteBuffer buf, Clazz clazz){
        MethodInfo methodInfo = new MethodInfo();
        String accessFlags = ByteBufferReaderUtil.readHexStr(buf,2);
        methodInfo.setAccessFlags(accessFlags);
        short nameIndex = ByteBufferReaderUtil.readShort(buf);
        System.out.println("开始解析方法"+clazz.index2Object(nameIndex));
        methodInfo.setNameIndex(nameIndex);
        short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
        methodInfo.setDescriptorIndex(descriptorIndex);
        short attributesCount = ByteBufferReaderUtil.readShort(buf);
        methodInfo.setAttributesCount(attributesCount);
        Attribute[] attributeInfo = new Attribute[attributesCount];

        for (int i = 0; i < attributesCount; i++) {
            Attribute attribute = attributeReader.read(buf,clazz);
            attributeInfo[i] = attribute;
            System.out.println("解析方法属性"+clazz.index2Object(attribute.getAttributeNameIndex()));
        }
        methodInfo.setAttributeInfo(attributeInfo);
        System.out.println("结束解析方法"+clazz.index2Object(nameIndex));
        return methodInfo;
    }
}
