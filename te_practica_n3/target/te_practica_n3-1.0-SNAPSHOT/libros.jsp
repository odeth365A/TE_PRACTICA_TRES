<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%
    List<Libros> libro = (List<Libros>) session.getAttribute("biblioteca");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
    </head>
    <body>
        <h1>Libros</h1>
        <p><a href="LibroController?op=nuevo">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Diponible</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
     <%
       if(libro !=null){
           for (Libros item : libro){  
     %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getTitulo()%></td>
                <td><%= item.getAutor()%></td>
                <td><%= item.getEstado()%></td>
                <td><%= item.getCat().getDescripcion()%></td>
                <td><a href="LibroController?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="LibroController?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>
            </tr>
      <%
          }
        }
     %>   
        </table>
        <p><a href="index.jsp"> Volver al inicio</a></p>
    </body>
</html>