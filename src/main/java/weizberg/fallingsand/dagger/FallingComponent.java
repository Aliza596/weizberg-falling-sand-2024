
package weizberg.fallingsand.dagger;

import dagger.Component;
import weizberg.fallingsand.SandFrame;

import javax.inject.Singleton;

@Singleton
@Component(modules = { FallingModule.class })
public interface FallingComponent {
    SandFrame frame();
}
