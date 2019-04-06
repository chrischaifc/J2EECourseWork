package com.fuchun;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/update", "/insert"}
)
//servlet for all pages

public class Wardrobe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StyleManager styleManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    //check different situation
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertCloth(request, response);
                break;
            case "/delete":
                deleteCloth(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCloth(request, response);
                break;
            default:
                listCloth(request, response);
                break;

        }
    }

    //list all
    private void listCloth(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<ClothesItem> clothesItemList = styleManager.getClothesItemList();
        request.setAttribute("listCloth", clothesItemList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    //add new
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClothForm.jsp");
        dispatcher.forward(request, response);
    }

    //show edit
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ClothesItem clothesItem = styleManager.getClothesItem(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClothForm.jsp");
        request.setAttribute("cloth", clothesItem);
        dispatcher.forward(request, response);
    }

    //insert
    private void insertCloth(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String name = request.getParameter("name");
        Type type = Type.valueOf(request.getParameter("type")) ;
        String color = request.getParameter("color");
        double price = Double.parseDouble(request.getParameter("price"));

        ClothesItem clothesItem = new ClothesItem(++StyleManager.ID_COUNT, name, type, color, price);
        styleManager.addClothesItem(clothesItem);
        response.sendRedirect("list");
    }

    //update
    private void updateCloth(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Type type = Type.valueOf(request.getParameter("type")) ;
        String color = request.getParameter("color");
        double price = Double.parseDouble(request.getParameter("price"));

        ClothesItem clothesItem = new ClothesItem(id, name, type, color, price);
        styleManager.updateClothesItem(clothesItem);
        response.sendRedirect("list");
    }

    //delete
    private void deleteCloth(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        styleManager.deleteClothesItem(id);
        response.sendRedirect("list");
    }


}
