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
            <%@ include file="/WEB-INF/jsp/inc/admin.navbar.jsp" %>
            <div class="row row-offcanvas row-offcanvas-right">
                <div class="container">
                    <div class="jumbotron">
                        <h1>Hermes</h1>
                        <p>ACCIONA Airport Services type B messaging retrieval system.</p>
                    </div>
                    <br>
                    <br>
                    <div class="container">
                        <h3><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>&nbsp;Latest inbound messages!</h3>
                        <% response.setIntHeader("Refresh", 60);%>
                        Last updated:<%= new java.util.Date()%>
                        <s:iterator value="newMessages">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><strong><input type="checkbox" aria-label="...">&nbsp;&nbsp;<s:property value="smi"/></strong>&nbsp;&nbsp;<s:property value="tex_flt"/></h3>
                                    
                                </div>
                                <div class="panel-body">
                                    <div class="well well-sm">
                                        <samp>
                                            <s:property escapeHtml="false" value="tex"/>
                                            <br/>
                                        </samp>
                                    </div>
                                </div>
                            </div>
                        </s:iterator>   
                    </div> <!-- /container -->
                </div><!--/row-->
            </div><!--/.container-->
    </body>
    <br><br>
    <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
</html>