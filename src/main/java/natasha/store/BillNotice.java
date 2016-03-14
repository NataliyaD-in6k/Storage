package natasha.store;

public class BillNotice {
    private Integer id;
    private String name;

    public BillNotice(String name) {
        this.name = name;
    }

    public BillNotice(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
