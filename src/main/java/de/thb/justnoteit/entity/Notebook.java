package de.thb.justnoteit.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

@Getter
@Setter
public class Notebook {
    private long id;
    private String name;
    private String description;
    private List<Note> notes;
    private String cover;
    private LocalDate published;

    public Notebook(long id, String name, String description, List<Note> notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.cover = "Cover";
        this.published = LocalDate.now();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ").append(id);
        sb.append("\nname: ").append(name);
        sb.append("\ndescription: ").append(description);
        sb.append("\ncover: ").append(cover);
        sb.append("\npublished: ").append(published);
        return sb.toString();
    }

    public int getNumberOfNotes(){
        return notes.size();
    }

    public Note getNote(int noteId){
        return this.notes.stream()
                .filter(note -> note.getId() == noteId)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    public Long getLatestNoteId(){
        return notes.get(notes.size() - 1).getId();
    }
}


