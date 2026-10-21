import java.util.Locale;

public class Task {
    private final int id;
    private final String title;
    private  boolean isCompleated;

    private final String dicription;
    private final String author;


    public Task(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.isCompleated = builder.isCompleated;
        this.dicription = builder.dicription;
        this.author = builder.author;
    }
    public static Builder builder(){
        return  new Builder();
    }
    public int getId(){return  id;}
    public String getTitle(){return title;}
    public  boolean isCompleated(){return  isCompleated;}

    public void setCompleated(boolean completed){
        this.isCompleated = completed;
    }
    @Override
    public String toString(){
        String status = isCompleated ? "[X]" : "[ ]";
        return id + "." + status + " " + title + " (Автор: " + author + ", Описание: " + dicription + ")";

    }
    public static class Builder{
        private int id;
        private String title;
        private boolean isCompleated = false;
        private String dicription = "Нет описания";
        private String author = "Аноним";

        public Builder id (int id){
            this.id = id;
            return this;
        }
        public Builder title(String title){
            this.title = title;
            return this;
        }
        public Builder isCompleated(boolean isCompleated){
            this.isCompleated = isCompleated;
            return  this;
        }
        public  Builder dicription(String dicription){
            this.dicription = dicription;
            return this;
        }
        public Builder author(String author){
            this.author = author;
            return this;
        }
        public Task build(){
            return new Task(this);
        }
    }
}
