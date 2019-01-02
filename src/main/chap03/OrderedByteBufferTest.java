package chap03;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class OrderedByteBufferTest {
	
	final String source = "Hello world";

	@Test
	public void pooledHeapBufferTest() {
		ByteBuf buf = Unpooled.buffer();
		assertEquals(ByteOrder.BIG_ENDIAN, buf.order());
		
		buf.writeShort(1);
		
		buf.markReaderIndex();
		assertEquals(1, buf.readShort());
		
		buf.resetReaderIndex();
		
		ByteBuf lettleEndianBuf = buf.order(ByteOrder.LITTLE_ENDIAN);
		assertEquals(256, lettleEndianBuf.readShort());
	}
	
	@Test
	public void convertNettyBufferToJavaBuffer() {
		ByteBuf buf = Unpooled.buffer(11);
		
		buf.writeBytes(source.getBytes());
		assertEquals(source, buf.toString(Charset.defaultCharset()));
		
		// netty ByteBuf를 자바의 nio ByteBuffer로 변환
		ByteBuffer nioByteBuffer = buf.nioBuffer();
		assertNotNull(nioByteBuffer);
		
		assertEquals(source, new String(nioByteBuffer.array(), nioByteBuffer.arrayOffset(), nioByteBuffer.remaining()));
		
	}
	
	@Test
	public void convertJavaBufferToNettyBuffer() {
		ByteBuffer byteBuffer = ByteBuffer.wrap(source.getBytes());
		ByteBuf nettyBuffer = Unpooled.wrappedBuffer(byteBuffer);
		assertEquals(source, nettyBuffer.toString(Charset.defaultCharset()));
	}
	
}
