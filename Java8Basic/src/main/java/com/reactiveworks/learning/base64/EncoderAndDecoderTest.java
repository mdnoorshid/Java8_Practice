package com.reactiveworks.learning.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * This class simply to show the Encoding and decoding that has enhanced in
 * java8 There are three types of Base64 encoding: 1)Simple 2)URL 3)MIME
 * 
 * @author Md Noorshid
 */
public class EncoderAndDecoderTest {
	static Logger logger = Logger.getLogger(EncoderAndDecoderTest.class);
	public void testEncodeAndDecode() {
		try {
			 // Encode and Decoding using basic encoder and decoder
			String textToTest = "Java8 Encoding and Decoding Test!!";
			String base64EncodedString = Base64.getEncoder().encodeToString(textToTest.getBytes("UTF-8"));
			logger.debug("base64EncodedString---> "+base64EncodedString);
			byte[] base64DecodedStringBytes=Base64.getDecoder().decode(base64EncodedString.getBytes("UTF-8"));
			String base64DecodedString=new String(base64DecodedStringBytes, "UTF-8");
			logger.debug("base64DecodedString---> "+base64DecodedString);
			
			//Encoded and Decoding using URL encoder and decoder
			     //Getting Encoder
			      Encoder encoder=Base64.getUrlEncoder();
			    //Encoding URL
                 String URL="http://52.201.18.79:9092/ecomm/json/signatureGPGroup/signatureGP/getBillAdrsForCreateCallService";
                 String URLEncodedFormat=encoder.encodeToString(URL.getBytes("UTF-8"));
                 logger.debug("URLEncodedFormat---> "+URLEncodedFormat);
                 //Decoding URL format,Getting Decoder
                 Decoder decoder=Base64.getUrlDecoder();
                 String URLDecodedFormat=new String(decoder.decode(URLEncodedFormat.getBytes("UTF-8")));
                 logger.debug("URLDecodedFormat---> "+URLDecodedFormat);
                 
          //Encoding and Decoding using MIME encoder and decoder
                 //Getting Encoder
                 Encoder encoderMimeObj=Base64.getMimeEncoder();
                 String mimeText="Hello \n This is String to test MIME Encoder and Decoder\r Lets test and run it";
                 String encodedMimeText=encoderMimeObj.encodeToString(mimeText.getBytes("UTF-8"));
                 logger.debug("encodeMimeText:: "+encodedMimeText);
                 //Getting Decoder
                 Decoder decoderMimeObj=Base64.getMimeDecoder();
                 String decodedMimeText=new String(decoderMimeObj.decode(encodedMimeText.getBytes("UTF-8")));
                 logger.debug("decodedMimeText:: "+decodedMimeText);    
			

		} catch (UnsupportedEncodingException e) {
			logger.error("Error---> " + e);
		}
	}
	public static void main(String[] args) {
		BasicConfigurator.configure();
		EncoderAndDecoderTest encoderAndDecoderTest=new EncoderAndDecoderTest();
		encoderAndDecoderTest.testEncodeAndDecode();
	}

}
