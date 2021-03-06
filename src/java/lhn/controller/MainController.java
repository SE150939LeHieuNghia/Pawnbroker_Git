/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class MainController extends HttpServlet {

    private final String ERROR="LoginPage.jsp";
    private final String LOGIN="LoginController";
    private final String CREATE="CreateUser.jsp";
    private final String FORGOT="ForgotPass.jsp";
    private final String GETKEY="GetKeyController";
    private final String COMPANY="CompanyPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try{
            String action =request.getParameter("action");
            switch(action){
                case "Login":
                    url = LOGIN;
                    break;
                case "Create User":
                    url = CREATE;
                    break;
                case "Forgot Password":
                    url = FORGOT;
                    break;
                case "Return":
                    url = "LoginPage.jsp";
                    break;
                case "Get Key":
                    url = GETKEY;
                    break;
                case "Submit":
                    url = FORGOT;
                    break;
                case "Company Page":
                    url=COMPANY;
                    break;
                case "Create new account"    :
                    url="CreateNewUserController";
                    break;
                default:
                     HttpSession session=request.getSession();
                     session.setAttribute("ERROR", "Funtion doesn't exsit");
                     break;
            }
        }catch(Exception e){
            log("Error at MainController" + e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
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
