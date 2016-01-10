package lol.data.jpa;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {FooValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FooValidateMe {

    String message() default "{Foo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}