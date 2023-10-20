package pl.bratek20.cookies.script;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.cli.*;

@Slf4j
public abstract class Script {
    public void run (String[] args) {
        // Define options and arguments
        Options options = new Options();
        Option inputOption = new Option("i", "input", true, "Input argument");
        options.addOption(inputOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            log.error("Error parsing command-line arguments: " + e.getMessage());
            new HelpFormatter().printHelp("MyCommandLineApp", options);
            System.exit(1);
            return;
        }

        // Handle the parsed arguments
        String input = cmd.getOptionValue("input");
        System.out.println("Input argument: " + input);
        // Implement your logic here based on the parsed arguments
    }
}
