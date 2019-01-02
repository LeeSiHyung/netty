package chap03;

import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import static org.junit.Assert.*;


public class CreateByteBufferByNettyTest {
	
	@Test
	public void createUnpooledHeapBufferTest() {
		// unPooled heap buffer
		ByteBuf buf = Unpooled.buffer(11);
		testBuffer(buf, false);
	}
	
	@Test
	public void createUnpooledDirectBufferTest() {
		// unPooled direct buffer
		ByteBuf buf = Unpooled.directBuffer(11);
		testBuffer(buf, true);
	}
	
	@Test
	public void createPooledHeapBufferTest() {
		// pooled heap buffer
		ByteBuf buf = PooledByteBufAllocator.DEFAULT.heapBuffer(11);
		testBuffer(buf, false);
	}
	
	@Test
	public void createPooledDirectBufferTest() {
		// pooled direct buffer
		ByteBuf buf = PooledByteBufAllocator.DEFAULT.directBuffer(11);
		testBuffer(buf, true);
	}
	
	private void testBuffer(ByteBuf buf, boolean isDirect) {
		assertEquals(11, buf.capacity());
		assertEquals(isDirect, buf.isDirect());
		assertEquals(0, buf.readableBytes());
		assertEquals(11, buf.writableBytes());
	}
	
}
