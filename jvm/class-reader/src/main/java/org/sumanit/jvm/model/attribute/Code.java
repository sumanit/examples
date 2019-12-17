package org.sumanit.jvm.model.attribute;

import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by 苏曼 on 2019/12/2.
 * JAVA 程序方法体中的代码经过编译后会存在Code属性内
 */
public class Code extends Attribute {
    /**
     *
     */
    private short maxStack;

    /**
     * 记录了局部变量表所需要的存储空间单位slot
     */
    private short maxLocals;
    /**
     *
     */
    private int codeLength;
    private byte[] codes;
    private short exceptionTableLength;
    private ExceptionInfo[] exceptionInfo;
    private short attributesCount;
    private Attribute[] attributes;

    public short getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(short maxStack) {
        this.maxStack = maxStack;
    }

    public short getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(short maxLocals) {
        this.maxLocals = maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public byte[] getCodes() {
        return codes;
    }

    public void setCodes(byte[] codes) {
        this.codes = codes;
    }

    public short getExceptionTableLength() {
        return exceptionTableLength;
    }

    public void setExceptionTableLength(short exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public ExceptionInfo[] getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(ExceptionInfo[] exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Code{" +
                "maxStack=" + maxStack +
                ", maxLocals=" + maxLocals +
                ", codeLength=" + codeLength +
                ", codes=" + Arrays.toString(codes) +
                ", exceptionTableLength=" + exceptionTableLength +
                ", exceptionInfo=" + Arrays.toString(exceptionInfo) +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
   public static class ExceptionInfo{
        private short startPc;
        private short endPc;
        private short handlerPc;
        private short catchType;

        public short getStartPc() {
            return startPc;
        }

        public void setStartPc(short startPc) {
            this.startPc = startPc;
        }

        public short getEndPc() {
            return endPc;
        }

        public void setEndPc(short endPc) {
            this.endPc = endPc;
        }

        public short getHandlerPc() {
            return handlerPc;
        }

        public void setHandlerPc(short handlerPc) {
            this.handlerPc = handlerPc;
        }

        public short getCatchType() {
            return catchType;
        }

        public void setCatchType(short catchType) {
            this.catchType = catchType;
        }
    }
}
