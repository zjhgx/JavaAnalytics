package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class Config {
	@Bean
	@DependsOn({ "fileReader", "fileWriter" })
	public FileProcessor fileProcessor() {
		System.out.println("xxxxxxxxxxxx");
		return new FileProcessor();
	}

	@Bean("fileReader")
	@DependsOn({ "fileWriter" })

	public FileReader fileReader() {
		System.out.println("rrrrrrrrrrrrrrrrr");

		return new FileReader();
	}

	@Bean("fileWriter")
	public FileWriter fileWriter() {
		System.out.println("wwwwwwwwwwwwwww");

		return new FileWriter();
	}

}

class FileProcessor {

}

class FileReader {

}

class FileWriter {

}
