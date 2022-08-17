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
    List<Peice> peices;

    public void Board(int size) {
        this.size = size;
        snakes = new ArrayList<>();
        ladders = new ArrayList<>();
        peices = new ArrayList<>();
    }

    public void setSnake(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadder(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void setPeices(List<Peice> peices) {
        this.peices = peices;
    }

    public List<Ladder> getLadders() {
        return this.ladders;
    }

    public List<Snake> getSnakes() {
        return this.snakes;
    }

    public List<Peice> getPeices() {
        return this.peices;
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
}


