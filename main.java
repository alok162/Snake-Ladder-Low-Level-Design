import java.util.UUID;

public class Snake {

    private int start;
    private int end;

    public void Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}

public class Ladder {

    private int start;
    private int end;

    public void Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}

public class Peice {
    
    private String color;
    private int position;
    
    public void Peice(String color) {
        this.color = color;
        this.position = 0;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }
}

public class Player {

    private int id;
    private String name;
    private Peice peice;

    public void Player(String name, Peice peice) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.peice = peice;
    }
}

public class Board {
    private int size;
    List<Snake> snakes;
    List<Ladder> ladders;
    Map<String, Player> boardPlayer;

    public void Board(int size) {
        this.size = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        boardPlayer = new HashMap<>();
    }

    public void setSnake(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadder(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void setBoardPlayer(Map<String, Integer> playerPeices) {
        this.boardPlayer = boardPlayer;
    }

    public List<Ladder> getLadders() {
        return this.ladders;
    }

    public List<Snake> getSnakes() {
        return this.snakes;
    }

    public Map<String, Integer> getBoardPlayer() {
        return this.playerPeices;
    }
}

public class DiceService {
    public static int roll() {
        return ew Random().nextInt(6) + 1;
    }
}

public class GameService {

    private boolean isGameOver;
    private Queue<Player> players;

    public void GameService(Queue<Player> players) {
        this.players = new LinkedList<>();
        
    }

    public void start() {
        while (!isGameOver) {
            
        }
    }

    public void move() {

    }

    public void stop() {
        this.isGameOver = true;
    }
    
    public void setLadder() {
        
}

public class Controller {
       
}


