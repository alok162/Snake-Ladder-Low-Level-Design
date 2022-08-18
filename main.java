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

    private String id;
    private String name;
    private Peice peice;

    public void Player(String name, Peice peice) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.peice = peice;
    }

    public String getId() {
        return this.id;
    }

    public int getPosition() {
        return this.peice.getPosition();
    }

    public String getName() {
        return this.name;
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
        return new Random().nextInt(6) + 1;
    }
}

public class GameService {

    private int playerCount;
    private Board board;
    private boolean isGameOver;
    private Queue<Player> qPlayers;
    private List<Player> players;

    public void GameService(List<Player> players) {
        this.qPlayers = new LinkedList<>();
        this.board = new Board(100);
        this.players = players;
        this.playerCount = players.size();
    }

    public void start() {
        while (!isGameOver) {
            DiceService diceService = new DiceService();
            Player player = this.qPlayers.remove();
            if (player.getPosition() >= 100)
                System.out.println(player.getName() + "has won the game");
            else {
                int diceOutcome = diceService.roll();
                // corner case if diceOutcome comes 6 then player gets one more chance to roll.
                // TODO .
                move(player, diceOutcome);
                qPlayers.add(player);
            }
        }
    }

    public void move(Player player, int diceOutcome) {
        int currentPlayerPosition = player.getPosition();
        if (this.board.getLadders().contains(diceOutcome + currentPlayerPosition)) {
            player.setPosition(this.board.getLadders.getEnd());
        } else if (this.board.getSnakes().contains(diceOutcome + currentPlayerPosition)) {
            player.setPosition(this.board.getSnakes.getEnd());
        } else {
            player.setPosition(diceOutcome + currentPlayerPosition);
        }
    }

    public void stop() {
        this.isGameOver = true;
    }
    
    public void setLadder(List<Ladder> ladders) {
        this.board.setLadder(ladders);
    }

    public void setSnake(List<Snake> snakes) {
        this.board.setSnake(snakes);
    }

    public void setBoardPlayer() {
        Map<String, Player> boardPlayer = new HashMap<>();
        for (Player player : this.players) {
            boardPlayer.put(player.getId(), player);
            this.qPlayers.add(player);
        }
        this.board.setBoardPlayer(boardPlayer);
    }
        
}

public class Controller {
       
       public static void main(String[] args) { 

            List<Snake> snakes = new ArrayList<>();
            snakes.add(new Snake(22, 7));
            snakes.add(new Snake(49, 30));

            List<Ladder> ladders = new ArrayList<>();
            ladders.add(new Ladder(2, 32));
            ladders.add(new Ladder(20, 75));
            
            List<Player> players = new ArrayList<>();
            Peice peice1 = new Peice("Green", 0);
            Player player1 = new Player("Alok1", peice)
            Peice peice2 = new Peice("Red", 0);
            Player player2 = new Player("Alok2", peice)

            players.add(player1);
            players.add(player2);

            GameService gameService = new GameService(players);
            gameService.setBoardPlayer(players);
            gameService.setLadder(ladders);
            gameService.setSnake(snakes);

            gameService.start();
       }
}