package chap03;


import org.junit.Test;
import static org.junit.Assert.*;

import java.nio.ByteBuffer;

public class ReadByteBufferTest {

	@Test
	public void readTest() {
		byte[] tempArray = {1, 2, 3, 4, 5, 0, 0, 0, 0 ,0, 0};
		ByteBuffer firstBuffer = ByteBuffer.wrap(tempArray);
		System.out.println(firstBuffer);
		assertEquals(0, firstBuffer.position());
		assertEquals(11, firstBuffer.limit());
		
		
		assertEquals(1, firstBuffer.get());
		assertEquals(2, firstBuffer.get());
		assertEquals(3, firstBuffer.get());
		assertEquals(4, firstBuffer.get());
		assertEquals(4, firstBuffer.position());
		assertEquals(11, firstBuffer.limit());
		
		firstBuffer.flip();
		
		assertEquals(0, firstBuffer.position());
		assertEquals(4, firstBuffer.limit());
		
		System.out.println(firstBuffer.get(0));
		System.out.println(firstBuffer.get(1));
		System.out.println(firstBuffer.get(2));
		System.out.println(firstBuffer.get(3));
		
		assertEquals(0, firstBuffer.position());
		
		
	}
}
