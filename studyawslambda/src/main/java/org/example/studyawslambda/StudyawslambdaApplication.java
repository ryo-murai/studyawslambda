package org.example.studyawslambda;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class StudyawslambdaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyawslambdaApplication.class, args);
	}

	@Bean
	public Function<SQSEvent, String> handleEvent() {
		return event -> {
			event.getRecords().forEach( record ->
					System.out.println(record.toString())
			);
			return event.toString();
		};
	}
}
