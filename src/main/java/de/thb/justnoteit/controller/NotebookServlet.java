package de.thb.justnoteit.controller;

import de.thb.justnoteit.entity.Note;
import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "NotebookController", value = "/NotebookController")
public class NotebookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeskService deskService;
    public NotebookServlet(){
        super();
        deskService = new DeskService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("<h1>Meine Notizbücher:</h1>");

        Enumeration parameters = request.getParameterNames();
        String parameterId = request.getParameter("id");
        String parameterNotes = request.getParameter("notes");  //new param-Variable for every possible param

        response.getWriter().append("<ul>");
        if (parameterId == null){
            List<Notebook> notebookList = deskService.getAllNotebooks();
            for (Notebook notebook : notebookList) {
                response.getWriter()
                        .append("<li>")
                        .append("<a href=localhost:8080/NotebookController?id=" + notebook.getId() + ">")
                        .append(notebook.getName() + "</a>");
                        for (Note note : notebook.getNotes()){
                            response.getWriter()
                                    .append("<ul> <li>")
                                    .append(note.getTitle())
                                    .append("</li> </ul>");
                        }
                        response.getWriter().append("</li>");

            }response.getWriter().append("</ul>");
        } else {
            try {
                response.getWriter()
                        .append(deskService
                                .getNotebookById(Long.parseLong(parameterId))
                                .toString());
            } catch (NullPointerException e) {
                response.getWriter().append("Das Notebook existiert nicht: \n");
                response.getWriter().append(e.getMessage());
            }
        }
    }
}
