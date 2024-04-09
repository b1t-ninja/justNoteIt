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
        this.cover = "replace me";          //needs to be changed
        this.published = LocalDate.now();   //currently sets present Time for all Notebooks
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ").append(this.id);
        sb.append("\nname: ").append(this.name);
        sb.append("\ndescription: ").append(this.description);
        sb.append("\ncover: ").append(this.cover);
        sb.append("\npublished: ").append(this.published);
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
//        Long latestId = 0L;
//        for (Note note: this.getNotes()){
//            if(latestId < note.getId()){
//                latestId = note.getId();
//            }
//        }
//        return latestId;
        return notes.get(notes.size() - 1).getId();
    }
}


