/**
 *  Copyright 2013 Wordnik, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wordnik.swagger.annotations;

import java.lang.annotation.*;

/**
 * Adds additional meta-data for operation parameters.
 * <p/>
 * This annotation can be used only in combination of JAX-RS 1.x/2.x annotations.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiParam {
    /**
     * The parameter name.
     * <p/>
     * The name of the parameter will be derived from the field/method/parameter name,
     * however you can override it.
     * <p/>
     * Body parameters will always be named "body". Path parameters will always be named
     * as the path section they represent.
     */
    String name() default "";

    /**
     * A brief description of the parameter.
     */
    String value() default "";

    /**
     * Describes the default value for the parameter.
     * <p/>
     * If the parameter is annotated with JAX-RS's {@code @DefaultValue}, that value would
     * be used, but can be overridden by setting this property.
     */
    String defaultValue() default "";

    /**
     * Limits the acceptable values for this parameter.
     * <p/>
     * If the original parameter type is an enum, the values of the enum would be translated to
     * the allowableValues. Those can be overridden by setting this property.
     * <p/>
     * There are three ways to describe the allowable values:
     * <ol>
     * <li>To set a list of values, provide a comma-separated list surrounded by square brackets.
     * For example: {@code [first, second, third]}.</li>
     * <li>To set a range of values, start the value with "range", and surrounding by square
     * brackets include the minimum and maximum values. For example: {@code range[1, 5]}.</li>
     * <li>To set a minimum/maximum value, use the same format for range but use "infinity"
     * or "-infinity" as the second value. For example, {@code range[1, infinity]} means the
     * minimum allowable value of this parameter is 1.</li>
     * </ol>
     */
    String allowableValues() default "";

    /**
     * Specifies if the parameter is required or not.
     * <p/>
     * Path parameters will always be set as required, whether you set this property or not.
     */
    boolean required() default false;

    /**
     * Allows for filtering a parameter from the API documentation.
     *
     * @see com.wordnik.swagger.core.filter.SwaggerSpecFilter
     */
    String access() default "";

    /**
     * Specifies whether the parameter can accept multiple comma-separated values.
     */
    boolean allowMultiple() default false;
}