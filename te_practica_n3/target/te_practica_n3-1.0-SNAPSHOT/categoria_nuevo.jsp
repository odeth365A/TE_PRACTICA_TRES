<%@page import="com.emergentes.modelo.Categoria"%>
<%
    Categoria item = (Categoria) request.getAttribute("item");
    String tipo = (String) request.getAttribute("tipo");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Categoria</title>
    </head>
    <body>
        <h1><%= (tipo == "new") ? "Nueva " : "Editar " %>Categoria</h1>
        <form action="CategoriaController" method="post">
            <input type="hidden" name="tipo" value="<%= tipo %>"/>
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=item.getId() %>"/></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="<%=item.getDescripcion() %>"/></td>
                <br><br>
                </tr>
                 <tr>
                    <td></td>
                    <td><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>