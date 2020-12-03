package com.interview.microsoft.design.logger;

public class LogDriver {

	public static void main(String[] args) {

		testLogger1();

		System.out.println("--------------------");
		
		testLogger2();
	}

	private static void testLogger1() {
		Logger logger = new MSLogger();

		logger.start("129", 12456);
		logger.start("145", 13956);

		logger.end("145", 13998);
		logger.end("129", 13000);

		logger.start("003", 16789);
		logger.start("2089", 17777);

		logger.end("003", 16998);
		logger.end("2089", 19000);

		logger.print();
	}

	private static void testLogger2() {
		Logger logger = new TSLogger();

		logger.start("129", 12456);
		logger.start("145", 13956);

		logger.end("145", 13998);
		logger.end("129", 13000);

		logger.start("003", 16789);
		logger.start("2089", 17777);

		logger.end("003", 16998);
		logger.end("2089", 19000);

		logger.print();
	}
}
