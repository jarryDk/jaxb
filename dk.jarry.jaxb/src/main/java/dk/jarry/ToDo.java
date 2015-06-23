package dk.jarry;

/**
 *
 * @author Michael Bornholdt Nielsen mni@jarry.dk
 */
public class ToDo {

    private Integer id;
    private String subject;
    private String body;

    public ToDo() {
    }
    
    public ToDo(Integer id, String subject, String body) {
        this.id = id;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public String toString() {
        return "ToDo{" + "id=" + id + ", subject=" + subject + ", body=" + body + '}';
    }
    
}
