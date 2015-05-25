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
                        <h3><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;Add a new user</h3>
                        <s:form name="doc" class="form-vertical" theme="bootstrap" cssClass="form-vertical well" method="post" action="Agregar_Usuario" >
                            <s:textfield name="user" id="user" label="User name" class="form-control" placeholder="Type here the user name..."/>
                            <s:textfield name="password" id="password" label="Password" class="form-control" placeholder="Type here the user password"/>
                            <s:radio
                                label="Role"
                                id="role"
                                labelposition="inline"
                                list="{'admin', 'user'}"
                                name="role"/>
                            <br>
                            <s:submit value="Create user" class="btn btn-primary" cssClass="btn btn-primary" type="button" />
                        </s:form>
                        <s:actionerror theme="bootstrap"/>
                        <s:if test="hasActionMessages()">
                            <s:actionmessage theme="bootstrap"/>
                        </s:if>

                        <h4>Active users list</h4>
                        <br>
                        <div class="table-responsive">
                            <table class="table table-striped table-hover table-bordered">
                                <tr class="default">
                                    <th>User</th>
                                    <th>Password</th>
                                    <th>Role</th>
                                    <th>Update</th>
                                    <th>Delete</th>
                                </tr>
                                <s:iterator value="listaUsuarios"> 
                                    <tr>
                                        <td><s:property value="user"/></td>
                                        <td><s:property value="password"/></td>
                                        <td><s:property value="role"/></td>
                                        <td><a href="Editar_Usuario.action?id_tb_user=${id_tb_user}&user=${user}&password=${password}&role=${role}"/><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a></td>
                                        <td><a href="Eliminar_Usuario.action?user=${user}"/><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </div>
                    </div> <!-- /container -->
                </div><!--/row-->
            </div><!--/.container-->
    </body>
    <br><br>
    <%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
</html>