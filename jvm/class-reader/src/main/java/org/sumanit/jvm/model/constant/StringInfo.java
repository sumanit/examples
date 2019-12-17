package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 字符串类型字面量
 */
public class StringInfo extends Constant {
    private short index;

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return String.valueOf(index2Str(index));
    }

    public String getTypeName() {
        return "String";
    }
}
