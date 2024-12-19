package weizberg.fallingsand.dagger;

import dagger.Module;
import dagger.Provides;
import weizberg.fallingsand.Sand;
import weizberg.fallingsand.SandComponent;
import weizberg.fallingsand.SandFrame;

import javax.inject.Singleton;

@Module
public interface FallingModule {

    int width = 300;
    int height = 400;


    @Singleton
    @Provides
    static Sand provideSand() {
        return new Sand(width, height);
    }

    @Provides static SandFrame provideSandFrame(
            Sand sand,
            SandComponent sandComponent
    ) {
        return new SandFrame(sand, sandComponent, width, height + 40);
    }

}
