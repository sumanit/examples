package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;
import org.sumanit.jvm.ClassReader;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public abstract class Attribute {
    private short attributeNameIndex;
    private int attributeLength;
    private ClassReader classReader;

    public ClassReader getClassReader() {
        return classReader;
    }

    public void setClassReader(ClassReader classReader) {
        this.classReader = classReader;
    }

    public abstract void readBody(ByteBuffer buf);

    public void read(ByteBuffer buf){
        attributeNameIndex = ByteBufferReaderUtil.readShort(buf);
        attributeLength = ByteBufferReaderUtil.readInt(buf);
        readBody(buf);
    }
}
