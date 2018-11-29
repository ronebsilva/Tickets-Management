
<!DOCTYPE html>
<html>
    <head>

        <link href="formatacao.css" type="text/css" rel="stylesheet" />
        <title>Menu Principal</title>
        <meta charset="UTF-8">

    </head>
    <body>

        <nav >
            <ul class="menu">
                <li><a href="#">Cadastros</a>
                    <ul>
                        <li><a href="./IncluirTicket">Ticket</a></li>                      

                    </ul>
                </li>
                <li><a href="#">Pesquisar</a>
                    <ul>
                        <li><a href="./ConsultarTicket">Ticket</a></li>

                    </ul>
                </li>
                <li><a href="#">Sobre</a>
                </li>
                <li><a href="#">Usuário: ${nome}</a>
                    <ul>
                        <li><a href="index.html">Sair</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <%@ include file="/rodape.jsp"%> 
    </body>
</html>
