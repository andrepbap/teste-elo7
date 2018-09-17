package andrepbap.carreiraselo7.app;

import android.app.Application;

import andrepbap.carreiraselo7.component.ApiComponent;
import andrepbap.carreiraselo7.component.DaggerApiComponent;

public class ApiApplication extends Application {

    private ApiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApiComponent.builder().build();
    }

    public ApiComponent getComponent() {
        return component;
    }

}
