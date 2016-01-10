package lol.data.jpa;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.Errors;

import javax.validation.*;
import javax.validation.bootstrap.GenericBootstrap;
import java.util.Map;
import java.util.Set;

public class BeanValidator implements org.springframework.validation.Validator,
        InitializingBean, ApplicationContextAware, ConstraintValidatorFactory {

    private Validator validator;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterPropertiesSet() throws Exception {
        GenericBootstrap bootstrap = Validation.byDefaultProvider();
        Configuration c = bootstrap.configure().constraintValidatorFactory(this);
    }

    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {

        Map beansByNames = applicationContext.getBeansOfType(key);
        if (beansByNames.isEmpty()) {
            try {
                return key.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Could not instantiate constraint validator class '" + key.getName() + "'", e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Could not instantiate constraint validator class '" + key.getName() + "'", e);
            }
        }
        if (beansByNames.size() > 1) {
            throw new RuntimeException("Only one bean of type '" + key.getName() + "' is allowed in the application context");
        }
        return (T) beansByNames.values().iterator().next();
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {
        // TODO ? What to do here
    }

    public boolean supports(Class clazz) {
        return true;
    }

    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }
    }
}