package com.codingblocks.firebase;

import android.content.Context;

/**
 * Created by harshitdwivedi on 6/4/18.
 */

public class Note {
    String title;
    String subtitle;

    public Note() {
    }

    public Note(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
