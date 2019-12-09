package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 表示方法句柄
 */

public class MethodHandleInfo extends Constant {
    private byte referenceKind;
    private short referenceIndex;

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }

    @Override
    public String toString() {
        return "{" +
                "referenceKind=" + referenceKind +
                ", reference=" + index2Str(referenceIndex) +
                '}';
    }

    public String getTypeName() {
        return "MethodHandle";
    }
}

