package ensa.jee.notes_mvc.mod.sco;
public class Note {
    private int id_note;
    private String num_ins;
    private String matiere;
    private float note;

    public Note( String matiere, float note) {

        this.matiere = matiere;
        this.note = note;
    }

    public Note(int id, String num_ins, String matiere, float note) {
        this.id_note = id;
        this.num_ins = num_ins;
        this.matiere = matiere;
        this.note = note;
    }
    public Note(){
        super();
    }
    public String getNum_ins() {
        return num_ins;
    }
    public void setNum_ins(String num_ins) {
        this.num_ins = num_ins;
    }
    public String getMatiere() {
        return matiere;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    public float getNote() {
        return note;
    }
    public void setNote(float note) {
        this.note = note;
    }
    public int getId_note() {
        return id_note;
    }
    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id_note=" + id_note +
                ", num_ins='" + num_ins + '\'' +
                ", matiere='" + matiere + '\'' +
                ", note=" + note +
                '}';
    }
}
