package weizberg.fallingsand;

import weizberg.fallingsand.dagger.DaggerFallingComponent;
import weizberg.fallingsand.dagger.FallingComponent;

public class Main {

    public static void main(String[] args) {

        FallingComponent component = DaggerFallingComponent
                .builder()
                .build();
        SandFrame frame = component.frame();
        frame.setVisible(true);

    }
}
