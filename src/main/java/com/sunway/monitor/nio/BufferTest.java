package com.sunway.monitor.nio;

import java.nio.ByteBuffer;

public class BufferTest {

	 public static void main(String[] ddd){

	        ByteBuffer byteBuffer = ByteBuffer.allocate(10);//底层为10 的byte[]数组
	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println(byteBuffer.position());
//	        System.out.println(byteBuffer.mark());
	        byteBuffer.put("abc".getBytes());
	        System.out.println("***************");
	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println(byteBuffer.position());//每一次put都会将值移动一次

	        System.out.println("**********flip（）********");

	        byteBuffer.flip();//将存入数据模式变成取出数据模式 已经存入的数据posstion又变成0，从头继续读

	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println("----"+byteBuffer.position());

	        System.out.println("**********get（）********");

	        System.out.println((char)byteBuffer.get());   //每get一次posstion+1
	        System.out.println((char)byteBuffer.get());
	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println(byteBuffer.position());

	        byteBuffer.rewind();//重置position
	        byteBuffer.clear();//清空  回到用户最初的状态  10，10，0
	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println(byteBuffer.position());
	        System.out.println((char)byteBuffer.get());   
	        System.out.println((char)byteBuffer.get());
	        System.out.println("**clear完了, 我啥都没有些 *flip（）********");
	        byteBuffer.flip();//将存入数据模式变成取出数据模式 已经存入的数据posstion又变成0，从头继续读
	        System.out.println(byteBuffer.capacity());
	        System.out.println(byteBuffer.limit());
	        System.out.println(byteBuffer.position());
	        System.out.println((char)byteBuffer.get());   //每get一次posstion+1
	        System.out.println((char)byteBuffer.get());
	        System.out.println((char)byteBuffer.get());

	    }

}
