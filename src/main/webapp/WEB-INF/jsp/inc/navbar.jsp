<!-- Static navbar -->
<nav id="barra" class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img style="max-width:100px; margin-top: -7px;" src="./pics/AAS.png"></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <form class="navbar-form navbar-right" action="Disconnect">
            <s:set name="usuario" value="#session.user"/>
            <s:if test="%{#usuario==null}"></s:if>
            <s:else><button type="submit" class="btn btn-danger">Close session <s:property value="#usuario" /></button></s:else>
        </form>
        </div>
    </div><!--/.container-fluid -->
</nav>