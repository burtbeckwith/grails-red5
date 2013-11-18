

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
 * Created by IntelliJ IDEA.
 * User: mchisholm
 * Date: Nov 9, 2007
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.beans.factory.config.MethodInvokingFactoryBean
import com.cantinaconsulting.grails.artifact.handler.*;
import org.red5.server.api.*;


class Red5GrailsPlugin {

        def version = 0.1
        def author = "Cantina Consulting <www.cantinaconsulting.com>"
        def authorEmail = "info@cantinaconsulting.com"
        def title = "Provides tools to host and manage video with grails"
        def documentation = "http://www.cantinaconsulting.com/grails-plugins/"
        def description = '''\
 This plugin is written for the Grails web application framework, and intends to make it relatively easy to use the Red5 functionality within Grails.  The goals of this plugin are as follows:

    * Provide an easy mechanism to develop new Red5 applications in Grails
    * Allow Red5 applications to use the GORM
    * Tie Red5 applications into a Spring Security model provided by Grails
    * Provide a deep integration between Grails and Red 5

 Please see http://www.cantinaconsulting.com/grails-plugins/ for more information.
 '''

    def loadAfter = ['core','hibernate','domainClass']
	def watchedResources = "file:./grails-app/red5/*Red5App.groovy"
    def artefacts = [new Red5AppArtefactHandler()]


   def configureRed5AppBeans = { red5AppClass ->

        def fullName = red5AppClass.fullName
        def shortName = red5AppClass.name

        "${fullName}Factory"(MethodInvokingFactoryBean) {
            targetObject = ref("grailsApplication", true)
            targetMethod = "getArtefact"
            arguments = [Red5AppArtefactHandler.TYPE, fullName]
        }

        "web.handler.${shortName}"(ref("${fullName}Factory")) { bean ->
            bean.factoryMethod = "newInstance"
            bean.autowire = "byName"
        }

        "web.context.${shortName}"(org.red5.server.Context) { bean ->
            scopeResolver=ref("red5.scopeResolver")
            clientRegistry=ref("global.clientRegistry")
            serviceInvoker=ref("global.serviceInvoker")
            mappingStrategy=ref("global.mappingStrategy")
        }

        "web.scope.${shortName}"(org.red5.server.WebScope) { bean -> 
            bean.initMethod="register"
            server=ref("red5.server")
            parent=ref("global.scope")
            context=ref("web.context.${shortName}")
            handler=ref("web.handler.${shortName}")
            contextPath="/${shortName}"
            virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
        }

	}



     def doWithSpring = {

        // TODO Add flex messaging for Grails apps

        //configure scopes and context by convention for Red5
            application.red5AppClasses.each { red5AppClass ->

                def fullName = red5AppClass.fullName

                configureRed5AppBeans.delegate = delegate
                configureRed5AppBeans(red5AppClass)


              /*
                "${fullName}"(red5AppClass.getClazz()) { bean ->
                       bean.autowire =  true
                 }


                "web.context.${fullName}"(org.red5.server.Context) { bean ->
                      scopeResolver=ref("red5.scopeResolver")
                      clientRegistry=ref("global.clientRegistry")
                      serviceInvoker=ref("global.serviceInvoker")
                      mappingStrategy=ref("global.mappingStrategy")
                 }

                "web.scope.${fullName}"(org.red5.server.WebScope) { bean ->

                     bean.initMethod="register"
                     server=ref("red5.server")
                     parent=ref("global.scope")
                     context=ref("web.context.${fullName}")
                     handler=ref(fullName)
                     contextPath="/${fullName}"
                     virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
                 }
              */

        }

         //SETUP Default Red5Apps

         // oflaDemo web context
          "web.context.oflaDemo"(org.red5.server.Context){
              scopeResolver=ref("red5.scopeResolver")
              clientRegistry=ref("global.clientRegistry")
              serviceInvoker=ref("global.serviceInvoker")
              mappingStrategy=ref("global.mappingStrategy")
          }

          "web.scope.oflaDemo"(org.red5.server.WebScope){ bean ->

             bean.initMethod="register"
             server=ref("red5.server")
             parent=ref("global.scope")
             context=ref("web.context.oflaDemo")
             handler=ref("web.handler.oflaDemo")
             contextPath="/oflaDemo"
             virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
          }

          "web.handler.oflaDemo"(org.red5.server.webapp.oflaDemo.Application)

          "demoService.service"(org.red5.server.webapp.oflaDemo.DemoService){ bean ->
              bean.lazyInit="true"
          }


          //SOSample context
          "web.context.SOSample"(org.red5.server.Context){
              scopeResolver=ref("red5.scopeResolver")
              clientRegistry=ref("global.clientRegistry")
              serviceInvoker=ref("global.serviceInvoker")
              mappingStrategy=ref("global.mappingStrategy")
          }

          "web.scope.SOSample"(org.red5.server.WebScope){ bean ->
              bean.initMethod="register"
              server=ref("red5.server")
              parent=ref("global.scope")
              context=ref("web.context.SOSample")
              handler=ref("web.handler.SOSample")
              contextPath="/SOSample"
              virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
          }

          "web.handler.SOSample"(org.red5.server.adapter.ApplicationAdapter)


          //echo web context
            "web.context.echo"(org.red5.server.Context){
                scopeResolver=ref("red5.scopeResolver")
                clientRegistry=ref("global.clientRegistry")
                serviceInvoker=ref("global.serviceInvoker")
                mappingStrategy=ref("global.mappingStrategy")

            }

            "web.scope.echo"(org.red5.server.WebScope) { bean ->

                bean.initMethod="register"
                server=ref("red5.server")
                parent=ref("global.scope")
                context=ref("web.context.echo")
                handler=ref("web.handler.echo")
                contextPath="/echo"
                virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
             }


            "web.handler.echo"(org.red5.server.webapp.echo.Application)

            "flexMessaging.service"(org.red5.server.net.remoting.FlexMessagingService){

                    serviceInvoker=ref("global.serviceInvoker")
                    endpoints=["Red5Echo":ref("web.handler.echo")]
             }


          // ROOT web context
          "web.context"(org.red5.server.Context){
              scopeResolver=ref("red5.scopeResolver")
              clientRegistry=ref("global.clientRegistry")
              serviceInvoker=ref("global.serviceInvoker")
              mappingStrategy=ref("global.mappingStrategy")
          }


          "web.scope"(org.red5.server.WebScope){ bean ->
              bean.initMethod="register"
              server=ref("red5.server")
              parent=ref("global.scope")
              context=ref("web.context")
              handler=ref("global.handler")
              contextPath="/root"
              virtualHosts="*,localhost, localhost:8080, 127.0.0.1:8080"
          }

        }


        def doWithApplicationContext = { applicationContext ->
                // TODO Implement post initialization spring config (optional)


        }


        def doWithWebDescriptor = { xml ->
                // TODO Implement additions to web.xml (optional)


        def contextparam = xml.'context-param'[0]
        contextparam + {

            'context-param' {

            'param-name'('globalScope')
            'param-value'('default')

            }

            'context-param' {

            'param-name'('parentContextKey')
            'param-value'('default.context')

            }


            'context-param' {

            'param-name'('webAppRootKey')
            'param-value'('/')

            }

            
            'context-param' {

            'param-name'('contextConfigLocation')
            'param-value'('WEB-INF/*-web.xml')

            }

        }


        def listeners = xml.'listener'[0]
        listeners + {

            /*
            TODO: find out ramifications of using the Grails context loader
            'listener' {
            'listener-class'('org.red5.server.war.WarLoaderServlet')

            }
            */
            

            'listener' {
            'listener-class'('org.springframework.web.context.request.RequestContextListener')

            }

        }


        def servlets = xml.servlet[0]
        servlets + {

            servlet {
            'servlet-name'('gateway')
            'servlet-class'('org.red5.server.net.servlet.AMFGatewayServlet')
            'load-on-startup'(2)
            }
            servlet {
            'servlet-name'('rtmpt')
            'servlet-class'('org.red5.server.net.rtmpt.RTMPTServlet')
            'load-on-startup'(3)
            }

        }


        def mappings = xml.'servlet-mapping'[0]
        mappings + {
            'servlet-mapping' {
            'servlet-name'('gateway')
            'url-pattern'('/gateway')
            }
            'servlet-mapping' {
            'servlet-name'('rtmpt')
            'url-pattern'('/open/*')
            }
            'servlet-mapping' {
            'servlet-name'('rtmpt')
            'url-pattern'('/idle/*')
            }
            'servlet-mapping' {
            'servlet-name'('rtmpt')
            'url-pattern'('/send/*')
            }

            'servlet-mapping' {
            'servlet-name'('rtmpt')
            'url-pattern'('/close/*')
            }

        }

        //add security constraints to the mappings
        mappings + {

            'security-constraint' {
                'web-resource-collection'{
                    'web-resource-name'('Forbidden')
                    'url-pattern'('/WEB-INF/*')
                }
                'auth-constraint'()
            }

            'security-constraint' {
                'web-resource-collection'{
                    'web-resource-name'('Forbidden')
                    'url-pattern'('/persistence/*')
                }
                'auth-constraint'()
            }

            'security-constraint' {
                'web-resource-collection'{
                    'web-resource-name'('Forbidden')
                    'url-pattern'('/streams/*')
                }
                'auth-constraint'()
            }

        }
            
        }
        def doWithDynamicMethods = { ctx ->
                // TODO Implement additions to web.xml (optional)
        }


        def onChange = { event ->

            //TODO: figure out reloading of the Red5 Application classes on change
            /*
           if(event.source) {

              def red5AppClass = application.addRed5AppClass(event.source)
              def red5AppName = "${red5AppClass.propertyName}"
              def beans = beans {
                   "$red5AppName"(red5AppClass.getClazz()) { bean ->
                       bean.autowire =  true
                    }
                    }
              if(event.ctx) {
                event.ctx.registerBeanDefinition(red5AppName,
                                               beans.getBeanDefinition(red5AppName))
              }
            }
            */

        }
        

        def onApplicationChange = { event ->
                // TODO Implement code that is executed when any class in a GrailsApplication changes
                // the event contain: event.source, event.application and event.applicationContext objects
        }
}