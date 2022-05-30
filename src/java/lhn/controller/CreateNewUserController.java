/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lhn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.CommunicationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lhn.key.KeyDAO;
import lhn.manager.ManagerDAO;
import lhn.manager.ManagerDTO;
import lhn.tool.Tool;

/**
 *
 * @author user
 */
@WebServlet(name = "CreateNewUserController", urlPatterns = {"/CreateNewUserController"})
public class CreateNewUserController extends HttpServlet {

    private final String ERROR = "CreateUser.jsp";
    private final String SUCCESS = "Homepage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        HttpSession session = request.getSession();
        try {
            boolean check = false;
            ManagerDAO dao = new ManagerDAO();
            KeyDAO daoKey = new KeyDAO();
            Tool tool = new Tool();
            String id = request.getParameter("id");
            if (tool.checkInt(id, 12,true) != "") {
                session.setAttribute("ERROR_ID", "ID " + tool.checkInt(id, 12,true));
                check=true;
            }else session.removeAttribute("ERROR_ID");
            String name = request.getParameter("name");
            if (tool.checkString(name, 1,false) != "") {
                session.setAttribute("ERROR_NAME", "Name " + tool.checkString(name, 1,false));
                check=true;
            }else session.removeAttribute("ERROR_NAME");
            String ph = request.getParameter("phone");
            if (tool.checkInt(ph, 10,true) != "") {
                session.setAttribute("ERROR_PHONE", "Phone " + tool.checkInt(ph, 10,true));
                check=true;
            }
            String password = request.getParameter("password");
            if (tool.checkString(password, 1,false) != "") {
                session.setAttribute("ERROR_PASSWORD", "Password " + tool.checkString(password, 1,false));
                check=true;
            }
            String confirm = request.getParameter("confirm");
            if (password.compareTo(confirm) != 0) {
                session.setAttribute("ERROR_CONFIRM", "Your password and confirm password must be the same");
                check=true;
            }
            String storeName = request.getParameter("storeName");
            if (tool.checkString(storeName, 1,false) != "") {
                session.setAttribute("ERROR_STORENAME", "Store name " + tool.checkString(storeName, 1,false));
                check=true;
            }
            String storeAddress = request.getParameter("storeAddress");
            if (tool.checkString(storeAddress, 1,false) != "") {
                session.setAttribute("ERROR_STOREADDRESS", "Store address " + tool.checkString(storeAddress, 1,false));
                check=true;
            }
            String key = request.getParameter("key");
            if (tool.checkString(key, 8,true) != "") {
                session.setAttribute("ERROR_KEY", "Key " + tool.checkString(key, 1,true));
                check=true;
            }
            if(daoKey.checkKey(key)!=-1){
                session.setAttribute("ERROR_KEY", "Key is not VALID");
                check=true;
            }
            if (check==false) {
               
            int phone = Integer.parseInt(ph);
                if (dao.createUser(id, name, phone, password, storeName, storeAddress, key)) {
                    daoKey.updateStatus(key);
                    session.setAttribute("MANAGER", new ManagerDTO(id, name, password, phone, storeName, storeAddress, key));
                    url = SUCCESS;
                }
            }
        } catch (NumberFormatException | SQLException e) {
            log("Error at CreateController " + e.toString());
        } finally {
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
