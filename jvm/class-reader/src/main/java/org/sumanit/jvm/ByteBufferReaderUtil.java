package org.sumanit.jvm;


import java.nio.ByteBuffer;

/**
 * Created by 苏曼 on 2019/12/2.
 */
public class ByteBufferReaderUtil {

    public static int readInt(ByteBuffer bf){

        int result = 0;
        for(int i=0;i<4;i++){
            byte b = bf.get();
            result = result<<8|(b& 0xFF);
        }
      return result;
    }
    public static long readLong(ByteBuffer bf){
        long result = 0L;
        for(int i=0;i<8;i++){
            byte b = bf.get();
            result = result<<8|(b& 0xFFL);
        }
        return result;
    }
    public static String readHexStr(ByteBuffer bf, int length){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            byte b = bf.get();
            String s = Integer.toHexString(b & 0xFF).toUpperCase();
            if(s.length()==1){
                sb.append("0");
            }
            sb.append(s);
        }
        return sb.toString();
    }
    public static byte[] readBytes(ByteBuffer bf, int length){
       byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = bf.get();
        }
        return result;
    }

    public static short readShort(ByteBuffer bf){
        int result = 0;
        for(int i=0;i<2;i++){
            byte b = bf.get();
            result = result<<8|(b& 0xFF);
        }
        return (short)result;
    }
    public static String readStr(ByteBuffer bf, int length){
        byte[] result = new byte[length];
        for(int i=0;i<length;i++){
            byte b = bf.get();
           result[i]=b;
        }
        return new String(result);
    }

    public static float readFloat(ByteBuffer bf){
        int i = readInt(bf);
        return Float.intBitsToFloat(i);
    }

    public static double readDouble(ByteBuffer bf){
        long i = readLong(bf);
        return Double.longBitsToDouble(i);
    }


}
