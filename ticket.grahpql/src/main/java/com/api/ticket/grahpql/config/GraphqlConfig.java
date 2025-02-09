package com.api.ticket.grahpql.config;

import com.api.ticket.grahpql.interpolator.ValidationInterpolator;
import graphql.validation.rules.OnValidationErrorStrategy;
import graphql.validation.rules.ValidationRules;
import graphql.validation.schemawiring.ValidationSchemaWiring;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
@RequiredArgsConstructor
public class GraphqlConfig {

    private final ValidationInterpolator validationInterpolator;



    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer(){
        ValidationRules validationRules = ValidationRules.newValidationRules()
                        .onValidationErrorStrategy(OnValidationErrorStrategy.RETURN_NULL)
                .messageInterpolator(validationInterpolator)
                .build();
        ValidationSchemaWiring schemaWiring = new ValidationSchemaWiring(validationRules);
        return builder -> builder.directiveWiring(schemaWiring).build();
    }
}
