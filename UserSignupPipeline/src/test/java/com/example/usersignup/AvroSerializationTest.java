package com.example.usersignup;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import com.example.avro.UserSignupEvent;

public class AvroSerializationTest {

	@Test
	void testSerialization() throws IOException {
		UserSignupEvent event = UserSignupEvent.newBuilder().setName("Ramesh").setEmail("ramesh@example.com")
//	                .setPhoneNumber("1234567890")
				.build();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		DatumWriter<UserSignupEvent> writer = new SpecificDatumWriter<>(UserSignupEvent.class);
		BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(outputStream, null);
		writer.write(event, encoder);
		encoder.flush();

		assertNotNull(outputStream.toByteArray());
	}
}
