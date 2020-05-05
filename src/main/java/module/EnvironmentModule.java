package module;

import java.util.Map;
import javax.inject.Named;
import javax.inject.Singleton;

import com.google.gson.Gson;
import dagger.Provides;

/**
 * Environment variable module.
 *
 * @author Rugal Bernstein
 */
@dagger.Module
public class EnvironmentModule {

  private String getEnv(final String label, final String defaultValue) {
    final Map<String, String> env = System.getenv();
    final String value = env.getOrDefault(label, defaultValue);
    System.out.printf("Use [%s] as [%s]%n", label, value);
    return value;
  }

  @Named(Constant.SERVICE_BUS_KEY)
  @Provides
  @Singleton
  public String provideServiceBusConnectionString() {
    return this.getEnv(Constant.SERVICE_BUS_KEY, Constant.SERVICE_BUS_VALUE);
  }

  @Provides
  @Singleton
  public Gson provideGson() {
    return new Gson();
  }
}
