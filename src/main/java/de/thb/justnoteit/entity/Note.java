package de.thb.justnoteit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Note {
    private long id;
    private String title;
    private String description;
    private boolean done;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ").append(this.id);
        sb.append("\ntitle: ").append(this.title);
        sb.append("\ndescription: ").append(this.description);
        sb.append("\ndone: ").append(this.done);
        return sb.toString();
    }
}

