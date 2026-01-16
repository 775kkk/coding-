package VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.inputlistener;

import java.util.Scanner;

public class CmdListener implements InputListener<String> {
    private Scanner scanner;
    private static final String END_COMMAND = "END";
    private boolean closed = false;
    public CmdListener() {
        this.scanner = new Scanner(System.in);
    }
    public String listenNextLine() {
        String line = scanner.nextLine();
        if (line.equals(END_COMMAND)) this.closed = true;
        return line;
    }
    public void close() {
        scanner.close();
    }
    public String run() {
        return listenNextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public boolean isClosed() {
        return closed;
    }
}
