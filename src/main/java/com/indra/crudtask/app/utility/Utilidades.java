package com.indra.crudtask.app.utility;
import org.apache.commons.codec.binary.Base64;
public class Utilidades {

	public String encode(String txt) {
	byte[] bytesEncoded = Base64.encodeBase64(txt.getBytes());
	return new String(bytesEncoded);
	}

	// Decode data on other side, by processing encoded data
	public String decode(String txt) {
		byte[] valueDecoded = Base64.decodeBase64(txt.getBytes());
		return new String(valueDecoded);
	}
}
