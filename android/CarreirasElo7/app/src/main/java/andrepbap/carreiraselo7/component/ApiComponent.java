package andrepbap.carreiraselo7.component;

import andrepbap.carreiraselo7.module.ApiModule;
import andrepbap.carreiraselo7.ui.MainActivity;
import dagger.Component;

@Component(modules = ApiModule.class)
public interface ApiComponent {

    void inject (MainActivity activity);

}
