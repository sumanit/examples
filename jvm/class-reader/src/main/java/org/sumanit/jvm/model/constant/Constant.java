package org.sumanit.jvm.model.constant;

import org.sumanit.jvm.model.Clazz;
import org.sumanit.jvm.reader.ClassReader;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public abstract class Constant {
    private Clazz clazz;

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    protected String index2Str(int index){
        return String.valueOf(clazz.getConstantPool()[index-1]);
    }

    public abstract String getTypeName();
}
