/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semanticweb;

import com.mycompany.semanticweb_1.jena.ModelNewResource;
import com.mycompany.semanticweb_1.jena.RDF;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import static org.apache.jena.shacl.vocabulary.SHACL.path;

/**
 *
 * @author Mlik
 */
@WebServlet(name = "CreateResource", urlPatterns = {"/resource"})
public class CreateResource extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        
        String path = request.getContextPath();
        
        ModelNewResource
                .create(request.getParameter("given"),
                        request.getParameter("family"));
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateResource</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateResource at " + request.getContextPath() + "</h1>");
            out.println("<p>Resource created </p>");
            
            // RDF.model.write(out); 
            StmtIterator iter = RDF.model.listStatements();
            // print out the predicate, subject and object of each statement
            while (iter.hasNext()) {
                Statement stmt      = iter.nextStatement();  // get next statement
                Resource  subject   = stmt.getSubject();     // get the subject
                Property  predicate = stmt.getPredicate();   // get the predicate
                RDFNode   object    = stmt.getObject();      // get the object

                out.print(subject.toString());
                out.print(" " + predicate.toString() + " ");
                if (object instanceof Resource) {
                    out.print(object.toString());
                } else {
                    // object is a literal
                    out.print(" \"" + object.toString() + "\"");
                }}
        
                    out.println("<p> <a href = \""+path+"\"> Home </a></p>");
                    out.println("</body>");
                    out.println("</html>");
            }
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
