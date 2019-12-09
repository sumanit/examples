package org.sumanit.jvm.reader.constant;

import org.sumanit.jvm.model.constant.Constant;
import org.sumanit.jvm.reader.ClassReader;

import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public abstract class ConstantReader<T extends  Constant> {

    public abstract T read(ByteBuffer buf);

    public static ConstantReader getReader(short tag){
        ConstantReader result = null;
        switch (tag){
            case 1: {
                result = new Utf8InfoReader();
                break;
            }
            case 3: {
                result = new IntegerInfoReader();
                break;
            }
            case 4: {
                result = new FloatInfoReader();
                break;
            }
            case 5 : {
                result = new LongInfoReader();
                break;
            }
            case 6: {
                result = new DoubleInfoReader();
                break;
            }
            case 7: {
                result = new ClassInfoReader();
                break;
            }
            case 8: {
                result = new StringInfoReader();
                break;
            }
            case 9: {
                result = new FieldrefInfoReader();
                break;
            }
            case 10: {
                result = new MethodrefInfoReader();
                break;
            }
            case 11: {
                result = new InterfaceMethodrefInfoReader();
                break;
            }
            case 12: {
                result = new NameAndTypeInfoReader();
                break;
            }
            case 15: {
                result = new MethodHandleInfoReader();
                break;
            }
            case 16: {
                result = new MethodTypeInfoReader();
                break;
            }
            case 18: {
                result = new InvokeDynamicInfoReader();
                break;
            }
        }
        return result;
    }

}
