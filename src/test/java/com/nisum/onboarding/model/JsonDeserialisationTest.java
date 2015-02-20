package com.nisum.onboarding.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.nisum.onboarding.model.hibernate.ParticipantHibernate;

public class JsonDeserialisationTest {

	private MappingJackson2HttpMessageConverter converter;

	@Before
	public void setUp() {
		converter = new MappingJackson2HttpMessageConverter();
	}

	@After
	public void tearDown() {
		converter = null;
	}

	@Test
	public void allClassesUsedByOurControllersShouldBeDeserialisableByJackson() throws Exception {
		assertCanBeMapped(ParticipantHibernate.class);
		assertCanBeMapped(Program.class);
		assertCanBeMapped(Task.class);
	}

	private void assertCanBeMapped(Class<?> classToTest) {
		String message = classToTest.getSimpleName()
				+ " is not deserialisable, check the swallowed exception in StdDeserializerProvider.hasValueDeserializerFor";
		assertThat(message, converter.canRead(classToTest, MediaType.APPLICATION_JSON), is(true));
	}

}
