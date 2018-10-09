package com.sunway.monitor.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

	public static void main(String[] args) throws IOException {
		//1.�ṩ��Ӧ�����������
        FileInputStream fis = new FileInputStream("D:\\���ܹ�������.md");
        FileOutputStream fos = new FileOutputStream("D:\\test.txt");

        //������Ӧ��Channel  ͨ�����ǵ���ȥ������Ӧ��ͨ����Ȼ��ͨ��ͨ��������д����
        FileChannel inchannel = fis.getChannel();
        FileChannel outchannel = fos.getChannel();

        //3.�ṩ������
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while ((inchannel.read(byteBuffer)) != -1) {

            byteBuffer.flip();//�л�Ϊ�����ݵ�ģʽ
            //������ﲻ�л��Ļ�������������

            outchannel.write(byteBuffer);
       
            byteBuffer.clear();//��գ����굱ǰ�Ļ�����Ȼ���ټ���
        }
        fis.close();
        fos.close();
        inchannel.close();
        outchannel.close();


	}

}
