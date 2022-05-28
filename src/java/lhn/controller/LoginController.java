/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lhn.manager.ManagerDAO;
import lhn.manager.ManagerDTO;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
private final String SUCCESS ="Homepage.jsp";
private final String ERROR ="LoginPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try{
            String id=request.getParameter("id");
            String password=request.getParameter("password");
            boolean check=false;
             if(id==""){
                request.setAttribute("Error_Login_ID", "ID can't be EMPTY");
                check=true;
            }else{
                  request.setAttribute("Error_Login_ID", null);
             }
             if(password==""){
                request.setAttribute("Error_Login_Password", "Password can't be EMPTY");
                check=true;
            }else{
                  request.setAttribute("Error_Login_Password", null);
             }
             if(!check){
            ManagerDAO dao=new ManagerDAO();
            ManagerDTO manager = dao.checkLogin(id, password);
            HttpSession session=request.getSession();
            if(manager!=null){
                session.setAttribute("Manager", manager);
                url=SUCCESS;
                 request.setAttribute("Error_Login", null);
            }else{
                request.setAttribute("Error_Login", "Manager don't exsit or wrong password");
            }
             }
        }catch(SQLException e){
            log("Error at LoginController "+e.toString());
        }finally{
            response.sendRedirect(url);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
