package module;

/**
 * Bundle component inject dependency.
 *
 * @author Rugal Bernstein
 */
import javax.inject.Named;
import javax.inject.Singleton;

import com.google.gson.Gson;
import dagger.Component;

/**
 * Component to bundle all module together.
 *
 * @author Rugal Bernstein
 */
@Singleton
@Component(modules = {EnvironmentModule.class})
public interface BundleComponent {

  Gson gson();

  @Named(Constant.SERVICE_BUS_KEY)
  String serviceBusConnectionString();
}
