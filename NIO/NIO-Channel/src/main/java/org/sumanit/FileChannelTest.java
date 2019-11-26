package org.sumanit;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 苏曼 on 2019/11/21.
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("F:\\VVAS\\Redis-x64-3.2.100\\dump.rdb", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
