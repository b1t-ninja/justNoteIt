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
        sb.append("\nid: ").append(id);
        sb.append("\ntitle: ").append(title);
        sb.append("\ndescription: ").append(description);
        sb.append("\ndone: ").append(done);
        return sb.toString();
    }
}

