package ensa.jee.notes_mvc.Controller;

import ensa.jee.notes_mvc.form.beans.NoteForm;
import ensa.jee.notes_mvc.mod.sco.Scolarite;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serial;

public class ControlleurServlet extends HttpServlet {
@Serial
    private static final long serialVersionUID = 1L;
@Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException {
    String num_ins=req.getParameter("num_inscription");
    Scolarite sco = new Scolarite();
    NoteForm nf = new NoteForm();

    nf.setNum_ins(num_ins);
    nf.setLesNotes(sco.getNotes(nf.getNum_ins()));


    HttpSession session = req.getSession();
    session.setAttribute("nf",nf);
    resp.sendRedirect("Notes.jsp");
}
}
