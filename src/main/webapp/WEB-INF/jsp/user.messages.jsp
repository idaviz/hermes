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
            <div class="container">
                <!-- Barra de navegación -->
                <%@ include file="/WEB-INF/jsp/inc/private.navbar.jsp" %>
                <div class="row row-offcanvas row-offcanvas-right">
                    <div class="container">
                        <div class="jumbotron">
                            <h1>Hermes</h1>
                            <p>ACCIONA Airport Services type B messaging retrieval system.</p>
                        </div>
                        <br>
                        <br>

                        <div class="panel-group" id="accordion" role="tablist" >
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            PSM
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <div>
                                            <s:iterator value="listaResultados">
                                                <s:if test="smi==\"PSM\"">
                                                    <s:property value="smi"/>
                                                    <s:property value="tex"/>
                                                    <br/>
                                                </s:if>
                                            </s:iterator>
                                        </div>                                    
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            LDM
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                    <div class="panel-body">
                                        <div>
                                            <s:iterator value="listaResultados">
                                                <s:if test="smi==\"LDM\"">
                                                    <s:property value="smi"/>
                                                    <s:property value="tex"/>
                                                    <br/>
                                                </s:if> 
                                            </s:iterator>
                                        </div>                                    
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingThree">
                                    <h4 class="panel-title">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                            MVT
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                    <div class="panel-body">
                                        <div>
                                            <s:iterator value="listaResultados">
                                                <s:if test="smi==\"MVT\"">
                                                    <s:property value="smi"/>
                                                    <s:property value="tex"/>
                                                     <br/>
                                                </s:if>
                                            </s:iterator>
                                        </div>                                    
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div><!--/row-->
                </div><!--/.container-->
            </div><!--/.container-->

    </body>

    <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
</html>