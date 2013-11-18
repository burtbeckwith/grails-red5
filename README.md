grails-red5
===========

This plugin is written for the Grails web application framework, and intends to make it relatively easy to use the Red5 functionality within Grails.  The goals of this plugin are as follows:

* Provide an easy mechanism to develop new Red5 applications in Grails
* Allow Red5 applications to use the GORM
* Tie Red5 applications into a Spring Security model provided by Grails
* Provide a deep integration between Grails and Red 5

Getting Started

- configure the plugin in BuildConfig.groovy

    plugins {
        compile ":red5:0.1"
    }
