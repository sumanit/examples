package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.SourceFile;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class SourceFileReader extends AttributeReader<SourceFile> {

    @Override
    public void readBody(ByteBuffer buf,SourceFile sourceFile) {
        short sourceFileIndex = ByteBufferReaderUtil.readShort(buf);
        sourceFile.setSourceFileIndex(sourceFileIndex);
    }

    @Override
    public SourceFile createAttribute() {
        return new SourceFile();
    }
}
