<%@page import="com.emergentes.modelo.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Libros"%>
<% 
    if(session.getAttribute("biblioteca") == null) {
        ArrayList<Libros> lisaux = new ArrayList<Libros>();
        session.setAttribute("biblioteca",lisaux);
    }
    if(session.getAttribute("categ")== null){
        ArrayList<Categoria> liscat = new ArrayList<Categoria>();
        
        liscat.add(new Categoria(1, "Novela"));
        liscat.add(new Categoria(2, "Historia"));
        liscat.add(new Categoria(3, "Cuento"));
        session.setAttribute("categ", liscat);        
    }
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Biblioteca</h1>
        <ul>
            <li><a href="libros.jsp">Libros</a></li>
            <br>
            <li><a href="categoria.jsp">Categorias</a></li>
        </ul>
    </body>
</html>