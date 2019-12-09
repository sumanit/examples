package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class SourceFile extends Attribute {
    private short sourceFileIndex;

    public short getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(short sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }
}
