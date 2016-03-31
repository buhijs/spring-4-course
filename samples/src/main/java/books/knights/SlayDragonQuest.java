package books.knights;

import java.io.PrintStream;

/**
 * Created by cda5732 on 18/03/2015.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Going to slay the Dragon!");
    }
}
