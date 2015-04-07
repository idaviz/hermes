<!-- Librerías -->
<%@ include file="/WEB-INF/jsp/inc/include.jsp" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="struts2, twitter, bootstrap, plugin, mibiblio" />
        <meta name="description" content="miBiblio document repository" />
        <title><s:text name="index.title" /></title>

        <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <sb:head includeScripts="true" includeScriptsValidation="true"/>
        <link href="./css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <!-- Barra de navegación -->
            <%@ include file="/WEB-INF/jsp/inc/navbar.jsp" %>
            <!-- Soporte para internacionalización -->
            <s:url id="indexEN" namespace="/" action="locale" >
                <s:param name="request_locale" >en</s:param>
            </s:url>
            <s:url id="indexES" namespace="/" action="locale" >
                <s:param name="request_locale" >es</s:param>
            </s:url>

            <s:a href="%{indexEN}" >English</s:a>
            <s:a href="%{indexES}" >Español</s:a>

                <!-- Fin soporte para internacionalización -->

                <div class="row row-offcanvas row-offcanvas-right">
                    <div class="container">
                        <div class="jumbotron">
                            <h1><span class="glyphicon glyphicon-send" aria-hidden="true"></span> hermes</h1>
                            <p><s:text name="jumbotron.introtext" /></p>
                    </div>
                    <br>
                    <br>
                    <div class="container">

                        <form class="form-signin">
                            <h2 class="form-signin-heading">Please sign in</h2>
                            <label for="inputEmail" class="sr-only">Email address</label>
                            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="remember-me"> Remember me
                                </label>
                            </div>
                            <button id="login-btn" class="btn btn-lg btn-danger btn-block" type="submit">Sign in</button>
                        </form>
                    </div> <!-- /container -->
                </div><!--/row-->
                
            </div><!--/.container-->
    </body>
    <br><br>
    <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
</html>