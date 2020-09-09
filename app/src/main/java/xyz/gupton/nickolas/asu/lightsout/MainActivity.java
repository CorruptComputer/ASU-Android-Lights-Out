package xyz.gupton.nickolas.asu.lightsout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Nickolas Gupton
 */
public class MainActivity extends AppCompatActivity {

    /**
     * NUM_ROWS | int: Number of rows.
     */
    private final int NUM_ROWS = 4;

    /**
     * NUM_COLUMNS | int: Number of columns.
     */
    private final int NUM_COLUMNS = 3;

    /**
     * colors | int[]: Colors for the buttons.
     */
    private final int[] colors = new int[]{
            Color.rgb(170, 170, 170), // a light gray
            Color.rgb(102, 136, 204), // a grayish blue
            Color.rgb(0, 85, 255)     // an intense blue
    };

    /**
     * gameBoard | LightsOutBoard: The game tracker.
     */
    private LightsOutBoard gameBoard;

    /**
     * lightButtons | Button[][]: 2D array of buttons to click.
     */
    private Button[][] lightButtons;


    /**
     * Called by Android when the app starts.
     * @param savedInstanceState Bundle: Given by Android when the app starts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gameBoard = new LightsOutBoard(this.NUM_ROWS, this.NUM_COLUMNS, this.colors.length);

        this.lightButtons = new Button[][]{
                {
                        findViewById(R.id.button00),
                        findViewById(R.id.button01),
                        findViewById(R.id.button02)
                },
                {
                        findViewById(R.id.button10),
                        findViewById(R.id.button11),
                        findViewById(R.id.button12)
                },
                {
                        findViewById(R.id.button20),
                        findViewById(R.id.button21),
                        findViewById(R.id.button22)
                },
                {
                        findViewById(R.id.button30),
                        findViewById(R.id.button31),
                        findViewById(R.id.button32)
                }
        };

        this.updateGameBoard();
    }

    /**
     * Updates the buttons on screen to match the game board.
     */
    private void updateGameBoard() {
        for (int row = 0; row < this.NUM_ROWS; row++) {
            for (int col = 0; col < this.NUM_COLUMNS; col++) {
                this.lightButtons[row][col].setBackgroundColor(
                        this.colors[this.gameBoard.getLightColor(row, col)]
                );
            }
        }

        TextView textView = findViewById(R.id.textView);
        if (this.gameBoard.isCleared()) {
            textView.setText("A WINNER IS YOU");
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.rgb(20, 150, 20));
        } else {
            textView.setText("Can you turn all thee lights out?");
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundColor(Color.WHITE);
        }
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click00(View view) {
        this.gameBoard.click(0, 0);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click01(View view) {
        this.gameBoard.click(0, 1);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click02(View view) {
        this.gameBoard.click(0, 2);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click10(View view) {
        this.gameBoard.click(1, 0);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click11(View view) {
        this.gameBoard.click(1, 1);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click12(View view) {
        this.gameBoard.click(1, 2);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click20(View view) {
        this.gameBoard.click(2, 0);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click21(View view) {
        this.gameBoard.click(2, 1);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click22(View view) {
        this.gameBoard.click(2, 2);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click30(View view) {
        this.gameBoard.click(3, 0);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click31(View view) {
        this.gameBoard.click(3, 1);
        this.updateGameBoard();
    }

    /**
     * Clicks the button.
     * @param view View: The view of the current button.
     */
    public void click32(View view) {
        this.gameBoard.click(3, 2);
        this.updateGameBoard();
    }

    /**
     * Starts a new game.
     * @param view View: The view of the current button.
     */
    public void startNewGame(View view) {
        this.gameBoard.randomize();
        this.updateGameBoard();
    }
}


