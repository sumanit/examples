package org.sumanit.jvm;

import org.sumanit.jvm.constant.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class ClassReader {

    Map<String,Constant> constantMap = new HashMap<String, Constant>();
    public void reader(File file) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(file, "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(2048);

        while (inChannel.read(buf)!= -1) {
            buf.flip();

           readHead(buf);
            buf.clear();

        }
        aFile.close();
    }

    private void readHead(ByteBuffer buf){
        String magic = ByteBufferReaderUtil.readHexStr(buf, 4);
        System.out.println("magic:"+magic);
        short minor_version = ByteBufferReaderUtil.readShort(buf);
        System.out.println("minor_version:"+minor_version);
        short major_version = ByteBufferReaderUtil.readShort(buf);
        System.out.println("major_version:"+minor_version);
        readConstantPool(buf);
        String accessFlags = ByteBufferReaderUtil.readHexStr(buf, 2);
        System.out.println("accessFlags:"+accessFlags);
        short classIndex = ByteBufferReaderUtil.readShort(buf);
        System.out.println("classIndex:"+classIndex);
        short superClassIndex = ByteBufferReaderUtil.readShort(buf);
        System.out.println("superClassIndex:"+superClassIndex);
        readInterfaces(buf);
        readFields(buf);
        readMethods(buf);


    }
    private void readMethods(ByteBuffer buf){
        short methodCount = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < methodCount; i++) {
            String accessFlags = ByteBufferReaderUtil.readHexStr(buf,2);
            System.out.println("method-accessFlags:"+accessFlags);
            short nameIndex = ByteBufferReaderUtil.readShort(buf);
            System.out.println("method-nameIndex:"+nameIndex);
            short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
            System.out.println("method-descriptorIndex:"+descriptorIndex);
            readAttributes(buf);
        }
    }
    private void readFields(ByteBuffer buf){
        short fieldCount = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < fieldCount; i++) {
            String accessFlags = ByteBufferReaderUtil.readHexStr(buf,2);
            System.out.println("field-accessFlags:"+accessFlags);
            short nameIndex = ByteBufferReaderUtil.readShort(buf);
            System.out.println("field-nameIndex:"+nameIndex);
            System.out.println(constantMap.get(String.valueOf(nameIndex)));
            short descriptorIndex = ByteBufferReaderUtil.readShort(buf);
            System.out.println("field-descriptorIndex:"+descriptorIndex);
            System.out.println(constantMap.get(String.valueOf(descriptorIndex)));
            readAttributes(buf);
        }

    }
    private void readAttributes(ByteBuffer buf){
        short attributesCount = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < attributesCount; i++) {

        }
    }
    private void readInterfaces(ByteBuffer buf){
        short interfaceCounts = ByteBufferReaderUtil.readShort(buf);
        for (int i = 0; i < interfaceCounts; i++) {

        }

    }
    private void readConstantPool(ByteBuffer buf){
        short constant_pool_count = ByteBufferReaderUtil.readShort(buf);
        System.out.println("constant_pool_count:"+constant_pool_count);
        for (int i = 1; i < constant_pool_count; i++) {
            Constant constant = readConstant(buf);
            constantMap.put(String.valueOf(i),constant);
            System.out.println(constant);
        }
    }

    private Constant readConstant(ByteBuffer buf){
        Constant result = null;
        byte tag = buf.get();
        System.out.println("tag:"+tag);
        switch (tag){
            case 1: {
                result = new Utf8Info();
                break;
            }
            case 3: {
                result = new IntegerInfo();
                break;
            }
            case 4: {
                result = new FloatInfo();
                break;
            }
            case 5 : {
                result = new LongInfo();
                break;
            }
            case 6: {
                result = new DoubleInfo();
                break;
            }
            case 7: {
                result = new ClassInfo();
                break;
            }
            case 8: {
                result = new StringInfo();
                break;
            }
            case 9: {
                result = new FieldrefInfo();
                break;
            }
            case 10: {
                result = new MethodrefInfo();
                break;
            }
            case 11: {
                result = new InterfaceMethodrefInfo();
                break;
            }
            case 12: {
                result = new NameAndTypeInfo();
                break;
            }
            case 15: {
                result = new MethodHandleInfo();
                break;
            }
            case 16: {
                result = new MethodTypeInfo();
                break;
            }
            case 18: {
                result = new InvokeDynamicInfo();
                break;
            }
        }
        result.read(buf);
        return result;

    }

    public static void main(String[] args) {
        ClassReader classReader = new ClassReader();
        try {
            classReader.reader(new File("F:\\examples\\NIO\\NIO-Channel\\target\\classes\\org\\sumanit\\Model1.class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
