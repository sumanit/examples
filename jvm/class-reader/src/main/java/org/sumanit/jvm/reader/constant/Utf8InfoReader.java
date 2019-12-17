package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.model.constant.Utf8Info;
import org.sumanit.jvm.reader.ByteBufferReaderUtil;
import sun.usagetracker.UsageTrackerClient;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 * UFT-8编码的字符串
 */
public class Utf8InfoReader extends ConstantReader<Utf8Info> {
    @Override
    public Utf8Info read(ByteBuffer buf) {
        short i = ByteBufferReaderUtil.readShort(buf);
        String value = ByteBufferReaderUtil.readStr(buf, i);
        Utf8Info utf8Info = new Utf8Info();
        utf8Info.setValue(value);
        return utf8Info;
    }

}
