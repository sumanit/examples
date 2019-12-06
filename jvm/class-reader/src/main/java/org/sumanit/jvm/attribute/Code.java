package org.sumanit.jvm.attribute;

import org.sumanit.jvm.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

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
    private byte[] exceptionInfo;
    private short attributesCount;
    private byte[] attributes;
    @Override
    public void readBody(ByteBuffer buf) {

        maxStack = ByteBufferReaderUtil.readShort(buf);
        maxLocals = ByteBufferReaderUtil.readShort(buf);
        int codeLength = ByteBufferReaderUtil.readInt(buf);
        byte[] codes = ByteBufferReaderUtil.readBytes(buf,codeLength);
        exceptionTableLength = ByteBufferReaderUtil.readShort(buf);
        exceptionInfo = ByteBufferReaderUtil.readBytes(buf,exceptionTableLength);
        attributesCount = ByteBufferReaderUtil.readShort(buf);

    }
}
