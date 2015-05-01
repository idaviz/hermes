<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img style="max-width:100px; margin-top: -7px;" src="./pics/AAS.png"></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <s:url action="main" var="newflightInputLink"/>
                <li><a href="${newflightInputLink}"><s:text name="Select new flight" /></a></li>                
            </ul>
            
            <form class="navbar-form navbar-right" action="Disconnect">
                <s:set name="usuario" value="#session.user"/>
                    <s:if test="%{#usuario==null}"></s:if>
                    <s:else><button type="submit" class="btn btn-danger">Close session <s:property value="#usuario" /></button></s:else>
            </form>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>