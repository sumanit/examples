package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.attribute.LineNumberTable;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LineNumberTableReader extends AttributeReader<LineNumberTable> {


    @Override
    public void readBody(ByteBuffer buf, LineNumberTable  lineNumberTable) {
        short lineNumberTableLength = ByteBufferReaderUtil.readShort(buf);
        lineNumberTable.setLineNumberTableLength(lineNumberTableLength);
        LineNumberInfoReader lineNumberInfoReader = new LineNumberInfoReader();
        LineNumberTable.LineNumberInfo[] lineNumberInfos = new LineNumberTable.LineNumberInfo[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i++) {
            LineNumberTable.LineNumberInfo lineNumberInfo = lineNumberInfoReader.read(buf);
            lineNumberInfos[i] = lineNumberInfo;
        }
        lineNumberTable.setLineNumberTable(lineNumberInfos);
    }

    @Override
    public LineNumberTable createAttribute() {
        return new LineNumberTable();
    }
    class LineNumberInfoReader{
        public LineNumberTable.LineNumberInfo read(ByteBuffer buf) {
            LineNumberTable.LineNumberInfo lineNumberInfo = new LineNumberTable.LineNumberInfo();
            short startPc = ByteBufferReaderUtil.readShort(buf);
            lineNumberInfo.setStartPc(startPc);
            short lineNumber = ByteBufferReaderUtil.readShort(buf);
            lineNumberInfo.setLineNumber(lineNumber);
            return lineNumberInfo;
        }
    }

}
