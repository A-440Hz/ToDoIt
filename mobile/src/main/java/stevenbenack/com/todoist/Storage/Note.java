package stevenbenack.com.todoist.Storage;

import com.google.gson.annotations.Expose;

import static stevenbenack.com.todoist.Storage.NoteType.empty;

public class Note {
    @Expose
    private String dateTime;
    @Expose
    private NoteText noteText;

    public Note(){
        // TODO: 10/23/2017 set date time automatically
        this.dateTime = null;
        this.noteText.setNoteType(empty);
        this.noteText.setTitleText("");
        this.noteText.setBodyText("");
    }

    public Note(String dateTime, NoteType noteType, String noteTitle, String noteBody) {
        // TODO: 10/23/2017 set date time automatically
        this.dateTime = dateTime;
        this.noteText.setNoteType(noteType);
        this.noteText.setTitleText(noteTitle);
        this.noteText.setBodyText(noteBody);
    }

    // DateTime getter and setter
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setNoteType(NoteType noteType){
        this.noteText.setNoteType(noteType);
    }
    public NoteType getNoteType(){
        return this.noteText.getNoteType();
    }

    public void setNoteTitle(String noteTitle){
        this.noteText.setTitleText(noteTitle);
    }
    public String getNoteTitle(){
        return this.noteText.getTitleText();
    }

    public void setNoteBody(String noteBody){
        this.noteText.setBodyText(noteBody);
    }
    public String getNoteBody(){
        return this.noteText.getBodyText();
    }

    private static class NoteText {
        @Expose
        private NoteType noteType;
        @Expose
        private String titleText;
        @Expose
        private String bodyText;

        // Note type getter and setter
        protected NoteType getNoteType() {
            return noteType;
        }
        private void setNoteType(NoteType noteType) {
            this.noteType = noteType;
        }

        // Note title getter and setter
        public String getTitleText() {
            return titleText;
        }
        private void setTitleText(String titleText) {
            this.titleText = titleText;
        }

        // Note body text getter and setter
        public String getBodyText() {
            return bodyText;
        }
        private void setBodyText(String bodyText) {
            this.bodyText = bodyText;
        }
    }
}
