package org.sumanit.jvm.reader.attribute;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.model.attribute.Attribute;
import org.sumanit.jvm.model.attribute.Code;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * JAVA 程序方法体中的代码经过编译后会存在Code属性内
 */
public class CodeReader extends AttributeReader<Code> {

    @Override
    public void readBody(ByteBuffer buf,Code code) {
        short maxStack = ByteBufferReaderUtil.readShort(buf);
        code.setMaxStack(maxStack);
        short maxLocals = ByteBufferReaderUtil.readShort(buf);
        code.setMaxLocals(maxLocals);
        int codeLength = ByteBufferReaderUtil.readInt(buf);
        code.setCodeLength(codeLength);
        byte[] codes = ByteBufferReaderUtil.readBytes(buf,codeLength);
        code.setCodes(codes);
        short exceptionTableLength = ByteBufferReaderUtil.readShort(buf);
        code.setExceptionTableLength(exceptionTableLength);
        ExceptionInfoReader exceptionInfoReader = new ExceptionInfoReader();
        Code.ExceptionInfo[] exceptionInfos = new Code.ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            Code.ExceptionInfo exceptionInfo = exceptionInfoReader.read(buf);
            exceptionInfos[i]=exceptionInfo;
        }
        code.setExceptionInfo(exceptionInfos);
        short attributesCount = ByteBufferReaderUtil.readShort(buf);
        code.setAttributesCount(attributesCount);
        AttributeReader attributeReader = new AttributeReader();
        Attribute[] attributes = new Attribute[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributes[i] = attributeReader.read(buf, code.getClazz());
        }

        code.setAttributes(attributes);

    }

    public Code createAttribute() {
        return new Code();
    }

    class ExceptionInfoReader {
        public Code.ExceptionInfo read(ByteBuffer buf) {
            Code.ExceptionInfo exceptionInfo = new Code.ExceptionInfo();
            short startPc = ByteBufferReaderUtil.readShort(buf);
            exceptionInfo.setStartPc(startPc);
            short endPc = ByteBufferReaderUtil.readShort(buf);
            exceptionInfo.setEndPc(endPc);
            short handlerPc = ByteBufferReaderUtil.readShort(buf);
            exceptionInfo.setHandlerPc(handlerPc);
            short catchType = ByteBufferReaderUtil.readShort(buf);
            exceptionInfo.setCatchType(catchType);
            return exceptionInfo;

        }
    }
}
