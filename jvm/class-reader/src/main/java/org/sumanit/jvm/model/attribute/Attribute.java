package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;
import org.sumanit.jvm.reader.ClassReader;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class Attribute {
    private short attributeNameIndex;
    private int attributeLength;
    private Clazz clazz;
    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
