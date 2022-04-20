
package com.emergentes.controlador;

import com.emergentes.modelo.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String op= (request.getParameter("op").equals("")) ? "listar" : request.getParameter("op");
       int id;
       Categoria c = new Categoria(0, "");
       HttpSession ses = request.getSession();
       List<Categoria> lista = (List<Categoria>) ses.getAttribute("categ");
       switch (op){
           case "nuevo":
               if(lista.size() == 0){
                   c.setId(1);
               }
               else{
                   c.setId(lista.get(lista.size()-1).getId()+1);
               }
            request.setAttribute("item", c);
            request.setAttribute("tipo","new");
            request.getRequestDispatcher("categoria_nuevo.jsp").forward(request, response);
            break;

            case "editar":
            id = Integer.parseInt(request.getParameter("id"));
            c = buscarNodo(id, request);
            request.setAttribute("item", c);
            request.setAttribute("tipo", "edit");
            request.getRequestDispatcher("categoria_nuevo.jsp").forward(request, response);
            break;

            case "eliminar":
            id = Integer.parseInt(request.getParameter("id"));
            c = buscarNodo(id, request);
            lista. remove(c);
            response.sendRedirect("categoria.jsp");
            break;

            case "listar":
            request.setAttribute("categ", lista);
            request.getRequestDispatcher("categoria.jsp"). forward(request, response);
             break;
       }
    }
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        int id = Integer .parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        String tipo = request.getParameter("tipo");
        Categoria c = new Categoria();
        c.setId(id);
        c.setDescripcion(descripcion);
        HttpSession ses = request.getSession();
        List<Categoria> lista = (List<Categoria>) ses.getAttribute("categ");
        if(tipo.equals("new")){
            lista.add(c);
        }
        else{
            int pos = posNodo(id, request);
            lista.set(pos,c);
        }
        response.sendRedirect("categoria.jsp");
        
    }
public Categoria buscarNodo(int id, HttpServletRequest request){
    Categoria aux = new Categoria();
    HttpSession ses = request.getSession();
    List<Categoria> lista = (List<Categoria>) ses.getAttribute("categ");
    for(Categoria obj : lista){
        if(obj.getId() == id){
            aux= obj;
            break;
        }
    }
    return aux;
    }
public int posNodo(int id, HttpServletRequest request){
    int index = -1;
    HttpSession ses = request.getSession();
    List<Categoria> lista = (List<Categoria>) ses.getAttribute("categ");
    for(int i=0; i<lista.size();i++){
        if(lista.get(i).getId()== id){
            index =i;
            break;
        }
    }
        return index;
    }
}


