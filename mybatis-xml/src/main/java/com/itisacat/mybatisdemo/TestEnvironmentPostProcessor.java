package com.itisacat.mybatisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;

public class TestEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        new Loader(environment, application.getResourceLoader()).load();
        System.out.println(environment.getProperty("test.additional"));
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    private static class Loader {
        private final ConfigurableEnvironment environment;
        private final ResourceLoader resourceLoader;
        private final List<PropertySourceLoader> propertySourceLoaders;

        Loader(ConfigurableEnvironment environment, ResourceLoader resourceLoader) {
            this.environment = environment;
            this.resourceLoader = (ResourceLoader) (resourceLoader == null ? new DefaultResourceLoader() : resourceLoader);
            this.propertySourceLoaders = SpringFactoriesLoader.loadFactories(PropertySourceLoader.class, this.getClass().getClassLoader());
        }

        private void load() {
            Iterator iterator = this.propertySourceLoaders.iterator();

            while (iterator.hasNext()) {
                PropertySourceLoader loader = (PropertySourceLoader) iterator.next();
                String[] extensions = loader.getFileExtensions();
                int length = extensions.length;

                for (int i = 0; i < length; ++i) {
                    String extension = extensions[i];
                    String location = "classpath:/qiuqiu." + extension;
                    this.load(location, loader);
                }
            }

        }

        private void load(String location, PropertySourceLoader loader) {
            try {
                Resource resource = this.resourceLoader.getResource(location);
                if (resource.exists()) {
                    String propertyResourceName = "TEST: [" + location + "]";
                    List<PropertySource<?>> propertySources = loader.load(propertyResourceName, resource);
                    if (propertySources != null) {
                        propertySources.forEach((source) -> {
                            this.environment.getPropertySources().addLast(source);
                        });
                    }
                }
            } catch (Exception var6) {
                throw new IllegalStateException("Failed to load property source from location '" + location + "'", var6);
            }
        }
    }
}
