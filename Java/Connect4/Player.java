public class Player {
    
    private String name;
    private char token;

    public String getName() {
        return name;
    }

    public char getToken() {
        return token;
    }
    
    Player(String name, char token) {        
        this.name = name;
        this.token = token;
    }

    // Used in draw case
    Player() {
        this.name = "Draw";
    }
}
