package chap03;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReadWriteByteBufferByNettyTest {
	
	@Test
	public void createUnpooledHeapBufferTest() {
		ByteBuf buf = Unpooled.buffer(11);
		testBuffer(buf, false);
	}
	
	@Test
	public void createUnpooledDirectBufferTest() {
		ByteBuf buf = Unpooled.directBuffer(11);
		testBuffer(buf, true);
	}
	
	@Test
	public void createPooledHeapBufferTest() {
		ByteBuf buf = PooledByteBufAllocator.DEFAULT.heapBuffer(11);
		testBuffer(buf, false);
	}
	
	@Test
	public void createPooledDirectBufferTest() {
		ByteBuf buf = PooledByteBufAllocator.DEFAULT.directBuffer(11);
		testBuffer(buf, true);
	}
	
	private void testBuffer(ByteBuf buf, boolean isDirect) {
		assertEquals(11, buf.capacity());
		assertEquals(isDirect, buf.isDirect());
		
		buf.writeInt(65537);
		assertEquals(4, buf.readableBytes()); // 4바이트 크기의 정수 (int = 4)
		assertEquals(7, buf.writableBytes()); // 4바이트 크기를 제외 (int = 4)
		
		assertEquals(1, buf.readShort()); // 2바이트만 읽기
		assertEquals(2, buf.readableBytes());
		assertEquals(7, buf.writableBytes());
		
		assertEquals(true, buf.isReadable());
		
		buf.clear();
		assertEquals(0, buf.readableBytes());
		assertEquals(11, buf.writableBytes());
		
	}

}
