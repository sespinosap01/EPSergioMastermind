/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.bean.Intento;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "ControladorJuego", urlPatterns = {"/ControladorJuego"})
public class ControladorJuego extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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

        String url = "JSP/vista.jsp";
        HttpSession sesion = request.getSession(true);
        List<Intento> intentos = (List<Intento>) sesion.getAttribute("intentos");
        if (intentos == null) {
            intentos = new ArrayList<>();
            sesion.setAttribute("intentos", intentos);
        }
        int cifraIntrod = (int) sesion.getAttribute("cifraIntrod");
        int numeroAleatorio = (int) sesion.getAttribute("numeroAleatorio");
        String resultado = "";
        String valorCampos = "";
        int valorCamposInt = 0;
        int muertos = 0;
        int heridos = 0;
        boolean acierto = false;

        for (int i = 1; i <= cifraIntrod; i++) {
            String nombreCampo = "campo" + i;
            valorCampos += request.getParameter(nombreCampo);
            valorCamposInt = Integer.parseInt(valorCampos);
        }

        if (valorCamposInt == numeroAleatorio) {
            resultado = "¡Has acertado!";
            acierto = true;

        } else {
            String numeroAleatorioStr = Integer.toString(numeroAleatorio);
            String valorCamposStr = Integer.toString(valorCamposInt);

            for (int i = 0; i < cifraIntrod; i++) {
                char c = valorCamposStr.charAt(i);
                if (c == numeroAleatorioStr.charAt(i)) {
                    muertos++;
                } else if (numeroAleatorioStr.indexOf(c) != -1) {
                    heridos++;
                }
            }
        }

        Intento intento = new Intento();
        intento.setNumIntroducido(valorCampos);
        intento.setMuertos(muertos);
        intento.setHeridos(heridos);
        intento.setValorCampos(valorCampos);
        intentos.add(intento);

        sesion.setAttribute("resultado", resultado);
        sesion.setAttribute("acierto", acierto);
        sesion.setAttribute("muertos", muertos);
        sesion.setAttribute("heridos", heridos);
        sesion.setAttribute("valorCampos", valorCampos);
        request.getRequestDispatcher(url).forward(request, response);
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
