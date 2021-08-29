package everyos.engine.ribbon.renderer.skijarenderer.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBImage;

public final class ImageUtil {
	private ImageUtil() {}
	
	public static Image fromInputStream(InputStream stream) {
		final int[] width = new int[1];
		final int[] height = new int[1];
		final int[] numChannels = new int[1];
		final ByteBuffer image;
		try {
			byte[] bytes = stream.readAllBytes();
			
			ByteBuffer buffer = BufferUtils.createByteBuffer(bytes.length);
			buffer.put(bytes);
			buffer.flip();
			
			image = STBImage.stbi_load_from_memory(buffer, width, height, numChannels, 4);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		image.flip();
		
		return new Image(image, width[0], height[0]);
	}
	
	public static class Image {
		final private ByteBuffer buffer;
		final private int width;
		final private int height;

		public Image(ByteBuffer imageBuffer, int width, int height) {
			this.buffer = imageBuffer;
			this.width = width;
			this.height = height;
		}
		
		public ByteBuffer getBuffer() {
			return this.buffer;
		}

		public int getWidth() {
			return this.width;
		}

		public int getHeight() {
			return this.height;
		}
	}
}
