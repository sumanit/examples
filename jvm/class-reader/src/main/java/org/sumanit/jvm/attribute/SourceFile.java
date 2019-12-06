package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class SourceFile extends Attribute {
    private short sourceFileIndex;
    @Override
    public void readBody(ByteBuffer buf) {
        sourceFileIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public String toString() {
        return "SourceFile{" +
                "sourceFileIndex=" + sourceFileIndex +
                '}';
    }
}
