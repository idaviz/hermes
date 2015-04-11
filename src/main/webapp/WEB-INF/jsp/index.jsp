<!-- Librerías -->
<%@ include file="/WEB-INF/jsp/inc/include.jsp" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="struts2, twitter, bootstrap, plugin, hermes, ACCIONA, messages" />
        <meta name="description" content="Type B message retrieval plataform" />
        <title>ACCIONA | Hermes</title>

        <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <sb:head includeScripts="true" includeScriptsValidation="true"/>
        <link href="./pics/favicon.ico" rel="shortcut icon">
        <link href="./css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <!-- Barra de navegación -->
            <%@ include file="/WEB-INF/jsp/inc/navbar.jsp" %>
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="container">
                    <div class="jumbotron">
                        <h1>Hermes</h1>
                        <p>ACCIONA Airport Services type B messaging retrieval system.</p>
                    </div>
                    <br>
                    <br>
                    <div class="container">
                        <s:form class="form-signin" theme="bootstrap" method="post" action="Connect">
                            <h2 class="form-signin-heading">Please, sign in...</h2>
                            <s:textfield name="user" id="user" class="form-control" placeholder="Your user"/>
                            <s:password name="password" id="password" class="form-control" placeholder="Your password"/>
                            <s:submit id="login-btn" value="Log in" class="btn btn-lg btn-danger btn-block" type="button"/> 
                        </s:form>
                    </div> <!-- /container -->
                </div><!--/row-->

            </div><!--/.container-->
    </body>
    <br><br>
    <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
</html>