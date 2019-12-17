package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/4.
 */
public class LineNumberTable extends Attribute {

    private short lineNumberTableLength;
    private LineNumberInfo[] lineNumberTable;

    public short getLineNumberTableLength() {
        return lineNumberTableLength;
    }

    public void setLineNumberTableLength(short lineNumberTableLength) {
        this.lineNumberTableLength = lineNumberTableLength;
    }

    public LineNumberInfo[] getLineNumberTable() {
        return lineNumberTable;
    }

    public void setLineNumberTable(LineNumberInfo[] lineNumberTable) {
        this.lineNumberTable = lineNumberTable;
    }

    public static class LineNumberInfo{
        private short startPc;
        private short lineNumber;

        public short getStartPc() {
            return startPc;
        }

        public void setStartPc(short startPc) {
            this.startPc = startPc;
        }

        public short getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(short lineNumber) {
            this.lineNumber = lineNumber;
        }
    }
}
