package com.example.demystifyspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public HelloMessageProvider messageProvider(HelloNameProvider helloNameProvider) {
        return new HelloMessageProvider(helloNameProvider);
    }

    @Bean
    static HelloPostProcessor postProcessor() {
        return new HelloPostProcessor();
    }

    static class HelloPostProcessor implements BeanDefinitionRegistryPostProcessor {
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(HelloNameProvider.class);
            beanDefinition.setInstanceSupplier(HelloNameProvider::new);
            registry.registerBeanDefinition("helloNameProvider", beanDefinition);
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        }
    }
}
