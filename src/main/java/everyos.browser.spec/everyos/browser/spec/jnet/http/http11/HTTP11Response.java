package everyos.browser.spec.jnet.http.http11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

import org.brotli.dec.BrotliInputStream;

import everyos.browser.spec.jnet.http.http11.HTTP11Request.REQUEST_TYPE;
import everyos.browser.spec.jnet.http.stream.ChunkedInputStream;
import everyos.browser.spec.jnet.http.stream.LimitedInputStream;

public class HTTP11Response {
	
	//TODO: Support cache
	
	private final Map<String, String> headers;
	private final int status;
	private final InputStream stream;

	public HTTP11Response(int status, Map<String, String> headers, InputStream stream) throws IOException {
		this.status = status;
		this.headers = headers;
		this.stream = decodeStream(wrapStream(stream));
	}

	public int getStatusCode() {
		return status;
	}
	
	public InputStream getInputStream() {
		return stream;
	}
	
	public String getContentType() {
		//TODO
		return headers.getOrDefault("content-type", "text/plain");
	}
	
	public String getAuthenticationChallenge() {
		return headers.get("www-authenticate");
	}
	public REQUEST_TYPE[] getAllow() {
		return null; //TODO
	}
	
	public String getHeader(String name) {
		return headers.get(name.toLowerCase());
	}
	
	public static enum RESPONSE_TYPE {
		INFORMATIONAL, SUCCESSFUL, REDIRECTION, CLIENT_ERROR, SERVER_ERROR
	}
	
	private InputStream wrapStream(InputStream stream) {
		if (headers.getOrDefault("transfer-encoding", "").equals("chunked")) {
			return new ChunkedInputStream(stream);
		} else if (headers.containsKey("content-length")) {
			return new LimitedInputStream(stream, Integer.valueOf(headers.get("content-length")));
		} else {
			return stream;
		}
	}
	
	private InputStream decodeStream(InputStream stream) throws IOException {
		String compression = headers.getOrDefault("content-encoding", "identity");
		
		if (compression.equals("gzip")) {
			return new GZIPInputStream(stream);
		} else if (compression.equals("br")) {
			return new BrotliInputStream(stream);
		} else if (compression.equals("deflate")) {
			return new DeflaterInputStream(stream);
		}
		
		return stream;
	}
}
