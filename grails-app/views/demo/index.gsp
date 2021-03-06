<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Grails Red 5 Plugin Demo</title>
        <style type="text/css">
<!--
body {
    margin: 0;
    font-family: sans-serif;
    font-size: 0.9em;
}
#footer {
    border-top: 1px solid red;
    font-size: 70%;
    margin: 0;
    padding: 0 0.5em;
    clear: both;
}
.code {
    font-family: monospace;
    font-size: 130%;
}
a {
    color: red;
    background: white;
    text-decoration: none;
}
h1 {
    padding: 0.6em 0;
    margin: 0;
    text-align: center;
    color: black;
    background: #d00;
    border-bottom: 3px solid black;
}
.demo {
    border-left: 2px dotted red;
    margin: 1em 0;
    padding-left: 1em;
}
.demo h2 {
    padding: 0.2em 1em 0 0;
    margin: 0;
    font-size: 110%;
}
.demo p {
    margin: 0;
}
.demo p a {
    font-size: 90%;
}
#content {
    margin: 0 2em;
}
#informations {
    padding-top: 1em;
    padding-bottom: 1em;
    border-bottom: 1px solid #a00;
}
#demos {
}
-->
</style>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
        </div>
        <div class="body">
              <h1>Red5 Samples</h1>
         <%
                //get meta data to build links to demo swfs
                def meta = grailsApplication.metadata
                def rootpath
                if(meta.get("app.context")){
                   rootpath = "."
                } else {
                   rootpath = "/" + meta.get("app.name")
                }
            %>

        <div id="content">

        <p id="informations">
        On this page you can find some sample applications that show the various
        features provided by Red5. The source code is available in the
        <span class="code">swf/DEV_Source</span> directory. Other examples are
        available in the <span class="code">swf/DEV_Deploy</span> directory.
        </p>

        <div id="demos">

        <div class="demo">
        <h2>Ball control</h2>
        <p>A simple shared ball demo that makes use of Shared Objects.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/BallControl.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>OFLA Demo</h2>
        <p>Simple video player as shown on the Online Open Source Flash conference.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/ofla_demo.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Port Tester</h2>
        <p>Simple port tester tool that determines which ports the Flash Player is able to connect through to the Red5 server.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/port_tester.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Publisher</h2>
        <p>Publishing program that can be used to publish, record and view videos.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/publisher.html">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Simple chat</h2>
        <p>Basic chat demo that uses Shared Objects to send chat messages.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/SimpleChat.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Simple broadcaster</h2>
        <p>A basic live video broadcaster.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/simpleBroadcaster.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Simple subscriber</h2>
        <p>A basic live video subscriber to be used with the simple subscriber.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/simpleSubscriber.swf">View demo</a></p>
        </div>

        <div class="demo">
        <h2>Simple recorder</h2>
        <p>A basic live video recorder.</p>
        <p><a href="${rootpath}${pluginContextPath}/demos/simpleRecorder.swf">View demo</a></p>
        </div>

        </div>
        </div>
        <div id="footer">
        Copyright &copy; 2006-2007 <a href="http://osflash.org/red5">The Red5 Project</a>.
        </div>
        </div>
    </body>
</html>