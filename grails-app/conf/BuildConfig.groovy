grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
		compile 'javax.activation:activation:1.1.1', {
			transitive = false
		}
		compile 'org.beanshell:bsh:2.0b5', {
			transitive = false
		}
		compile 'commons-httpclient:commons-httpclient:3.1', {
			transitive = false
		}
		compile 'commons-modeler:commons-modeler:2.0.1', {
			transitive = false
		}
		compile 'rhino:js:1.6R7', {
			transitive = false
		}
		compile 'org.apache.mina:mina-core:1.1.2', {
			transitive = false
		}
		compile 'org.apache.mina:mina-filter-ssl:1.1.2', {
			transitive = false
		}
		compile 'org.apache.mina:mina-integration-jmx:1.1.2', {
			transitive = false
		}
		compile 'org.apache.mina:mina-integration-spring:1.1.2', {
			transitive = false
		}
		compile 'quartz:quartz:1.5.2', {
			transitive = false
		}
		compile 'org.python:jython:2.2', {
			transitive = false
		}
		compile 'org.mortbay.jetty:jetty:6.1.26', {
			export = false
			transitive = false
		}
	}

	plugins {
		build ':release:2.2.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}
