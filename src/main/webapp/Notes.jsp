<%@ page import="ensa.jee.notes_mvc.form.beans.NoteForm" %>
<%@ page import="ensa.jee.notes_mvc.mod.sco.Note" %>
<%@ page import="java.util.Vector" %>
<%@ page buffer="8kb" autoFlush="true" %>

<%
    NoteForm noteF  = (NoteForm) session.getAttribute("nf");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&eacute;sultats</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        table, th, td {
            border: 3px double black;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        input[type="text"] {
            width: 200px;
        }

        input[type="submit"] {
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<form action="afficherNote.php" method="post">
    <label for="num_inscription">Num Inscription :</label>
    <input type="text" id="num_inscription" name="num_inscription" >
    <input type="submit" value="OK">
</form>

<% if (noteF != null) {
    Vector<Note> notes = noteF.getLesNotes();
    float totalNotes = 0;
    int count = notes.size();
    if (count > 0) { %>
<table>
    <tr>
        <th>Mati&egrave;re</th>
        <th>Note</th>
    </tr>
    <%
        int i=0;
        while (i<count) {
           float n= notes.get(i).getNote();
%>
<tr>
    <td><%= notes.get(i).getMatiere() %></td>
    <td><%= n %></td>
</tr>
<%
        totalNotes += n;
        i++;
    }
    %>
    <tr>
        <td><strong>Moyenne</strong></td>
        <td><strong><%= totalNotes / count %></strong></td>
    </tr>
</table>
<% }} else { %>
<p>Pas de notes disponibles pour cet étudiant.</p>
<%
    }
 %>


</body>
</html>
