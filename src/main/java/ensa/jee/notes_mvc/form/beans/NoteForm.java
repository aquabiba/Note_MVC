package ensa.jee.notes_mvc.form.beans;

import ensa.jee.notes_mvc.mod.sco.Note;

import java.util.Vector;

public class NoteForm {
    private String num_ins;
    private Vector<Note> LesNotes;

    public String getNum_ins() {
        return num_ins;
    }

    public void setNum_ins(String num_ins) {
        this.num_ins = num_ins;
    }

    public Vector<Note> getLesNotes() {
        return LesNotes;
    }

    public void setLesNotes(Vector<Note> lesNotes) {
        this.LesNotes = lesNotes;
    }
}
