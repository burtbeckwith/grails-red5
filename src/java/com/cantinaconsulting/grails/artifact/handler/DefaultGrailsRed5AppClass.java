/* Copyright 2006-2007 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
* For more information please visit www.cantinaconsulting.com
* or email info@cantinaconsulting.com
*/

/**
 * @author mchisholm
 */
package com.cantinaconsulting.grails.artifact.handler;

import org.codehaus.groovy.grails.commons.AbstractInjectableGrailsClass;

public class DefaultGrailsRed5AppClass extends AbstractInjectableGrailsClass implements GrailsRed5AppClass, GrailsRed5AppClassProperty {

	public static final String RED5APP = "Red5App";

	public DefaultGrailsRed5AppClass(Class<?> clazz) {
		super(clazz, RED5APP);
	}
}
