package pl.bratek20.cookies.cli;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.util.NoSuchElementException;
import java.util.Scanner;

@RequiredArgsConstructor
@Slf4j
public class CLIApp implements CommandLineRunner {
    private final CLILineHandler cliLineHandler;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        log.info("Enter text. Type 'exit' to exit");

        while (true) {
            String line;
            try {
                line = scanner.nextLine();
            }
            catch (NoSuchElementException e) {
                log.info("No more lines to read");
                break;
            }

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            String output = cliLineHandler.handleLine(line);
            log.info(output);
        }

        log.info("Exiting the application");
    }
}
