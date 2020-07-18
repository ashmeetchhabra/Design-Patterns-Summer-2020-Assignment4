package arrayvisitors.driver;

public class Driver {

	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

	public static void main(String[] args) {

		if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}"))
				|| (args[2].equals("${commonintsout}")) || (args[3].equals("${missingintsout}"))
				|| (args[4].equals("${debug}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}

	}

}
