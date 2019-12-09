package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.SourceFile;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class SourceFileReader extends AttributeReader<SourceFile> {
    private short sourceFileIndex;
    @Override
    public void readBody(ByteBuffer buf,SourceFile sourceFile) {
        sourceFileIndex = ByteBufferReaderUtil.readShort(buf);
    }

    @Override
    public SourceFile createAttribute() {
        return new SourceFile();
    }
}
