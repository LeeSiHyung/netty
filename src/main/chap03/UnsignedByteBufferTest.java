package chap03;


import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import static org.junit.Assert.*;

public class UnsignedByteBufferTest {
	
	final String source = "Hello world";
	
	@Test
	public void unsignedBufferToJavaBuffer() {
		ByteBuf buf = Unpooled.buffer(11);
		buf.writeShort(-1);
		// 0바이트 부터 2바이트 읽음 return 은 short -> int
		assertEquals(65535, buf.getUnsignedShort(0));
	}
	

}
