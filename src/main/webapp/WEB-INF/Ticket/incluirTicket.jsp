<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="formatacao.css"/>
        <title>Inserir Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="js/functionsProduto.js" type="text/javascript"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>



    </head>
    <body>
        <nav>
            <h2 style="color: white">Abrir novo Ticket</h2>
            <main class="container">
                <div class="row">
                    <div class="col-12">
                        <div>
                            <form method="post" action="${pageContext.request.contextPath}/IncluirTicket">
                                <div class="form-group row">
                                    
                                    <label class="col-sm-2 col-form-label" for="txtTitulo">Titulo</label>
                                    <div>
                                        <input style="width: 400px;" id="txtTitulo" required="required" type="text" name="txtTitulo" id="marca" />
                                    </div>
                                </div>
                                 
                                <div class="form-group row">
                                    <label class="col-sm-2 col-form-label" for="descricao">Descrição</label>
                                    <div class="col-sm-10">
                                        <textarea required="required" style="width: 600px;" id="txtDescricao" name="txtDescricao"></textarea>
                                    </div>
                                </div>
                                </div>
                                <button type="submit" onClick="confirmation()">Salvar</button>
                                <button type="reset">Limpar</button>
                                <button type="reset" onclick="window.location.href = 'menu.jsp';">Voltar</button>

                            </form>

                        </div>
                    </div>
                </div>
            </main>
        </nav>
        <%@ include file="/rodape.jsp"%> 
    </body>
</html>