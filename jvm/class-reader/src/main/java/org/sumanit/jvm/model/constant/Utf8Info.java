package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * UFT-8编码的字符串
 */
public class Utf8Info extends Constant {
    String value = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getTypeName() {
        return "Utf8";
    }
}
