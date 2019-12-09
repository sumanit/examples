package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.DoubleInfo;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * 双精度浮点类型字面量
 */
public class DoubleInfoReader extends ConstantReader<DoubleInfo> {
    @Override
    public DoubleInfo read(ByteBuffer buf) {
        DoubleInfo doubleInfo = new DoubleInfo();
        double value = ByteBufferReaderUtil.readDouble(buf);
        doubleInfo.setValue(value);
        return doubleInfo;
    }

}
