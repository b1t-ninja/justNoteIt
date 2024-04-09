package de.thb.justnoteit.repository;

import de.thb.justnoteit.entity.Note;
import de.thb.justnoteit.entity.Notebook;
import java.util.ArrayList;
import java.util.List;

public class NotebookDA {
    private List<Notebook> notebooks;

    public NotebookDA() {
        notebooks = new ArrayList<Notebook>();
        List<Note> notes = new ArrayList<Note>();
        notes.add(new Note(1, "erste Notiz", "dies ist die allererste Notiz", false));
        notes.add(new Note(2, "zweite Notiz", "dies ist die zweite Notiz", false));

        List<Note> notes2 = new ArrayList<>();
        notes2.add(new Note(3, "dritte Notiz", "dies ist die dritte Notiz", false));
        notes2.add(new Note(4, "vierte Notiz", "dies ist die vierte Notiz", false));

        Notebook nb = new Notebook(1, "Erstes Notizbuch", "mein erstes Notizbuch", notes);
        Notebook nb2 = new Notebook(2, "Zweites Notizbuch", "mein zweites Notizbuch", notes2);
        notebooks.add(nb);
        notebooks.add(nb2);
    }

    public List<Notebook> findAll() {
        return notebooks;
    }

    public Notebook findById(long id) {
        return notebooks
                .stream()
                .filter(notebook -> notebook.getId() == id)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public List<Notebook> findByName(String name) {
        return notebooks
                .stream()
                .filter(notebook -> notebook.getName().equals(name))
                .toList();
    }

    public List<Notebook> addEntryToList(Long notebookId){
        Notebook notebook = this.findById(notebookId);
        notebook.getNotes().add(new Note((notebook.getLatestNoteId()) + 1, "new Note", "New Note", false));
        return notebooks;
    }

    public List<Notebook> addEntryToListWithTitle(Long notebookId, String title){
        Notebook notebook = this.findById(notebookId);
        notebook.getNotes().add(new Note((notebook.getLatestNoteId()) + 1, title, "New Note", false));
        return notebooks;
    }
}
