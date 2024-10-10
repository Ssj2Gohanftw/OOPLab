import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PenaltyShootout extends JPanel {
    private Image ball_image;
    private Image gk_image;
    private Image goalpost_image;
    private int goalsScored = 0;
    private int goalsSaved = 0;
    private JButton leftBtn, ctrBtn, rightBtn;
    private JLabel scorelbl;
    private JLabel resultMessage;

    private int ballX = 375, ballY = 600;
    private int gkX = 300, gkY = 150;
    private int playerShot;
    private int goalkeeperMove;
    private boolean isBallMoving = false;
    private boolean isGkMoving = false;
    private final Random random;

    private Timer ballTimer;
    private Timer gkTimer;

    private int shotsTaken = 0;
    private static final int MAX_SHOTS = 5;

    public PenaltyShootout() {
        random = new Random();


        gk_image = new ImageIcon("src/Images/gk.png").getImage();
        ball_image = new ImageIcon("src/Images/Football.png").getImage();
        goalpost_image = new ImageIcon("src/Images/ftp.jpg").getImage();

        setPreferredSize(new Dimension(800, 600));
        setLayout(null);

        scorelbl = new JLabel("Goals Scored: 0   Goals Missed: 0");
        scorelbl.setFont(new Font("Arial", Font.BOLD, 24));
        scorelbl.setBounds(10, 10, 600, 50);
        add(scorelbl);

        resultMessage = new JLabel("", SwingConstants.CENTER);
        resultMessage.setBounds(250, 500, 300, 30);
        add(resultMessage);


        leftBtn = new JButton("Shoot Left");
        ctrBtn = new JButton("Shoot Center");
        rightBtn = new JButton("Shoot Right");

        leftBtn.setBounds(200, 550, 100, 30);
        ctrBtn.setBounds(350, 550, 100, 30);
        rightBtn.setBounds(500, 550, 100, 30);

        add(leftBtn);
        add(ctrBtn);
        add(rightBtn);


        leftBtn.addActionListener(new ShotListener("left"));
        ctrBtn.addActionListener(new ShotListener("center"));
        rightBtn.addActionListener(new ShotListener("right"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.drawImage(goalpost_image, 275, 100, 250, 250, this);

        g.drawImage(gk_image, gkX, gkY, 200, 300, this);

        g.drawImage(ball_image, ballX, ballY, 50, 50, this);
    }

    private class ShotListener implements ActionListener {
        private String direction;

        public ShotListener(String direction) {
            this.direction = direction;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (shotsTaken < MAX_SHOTS) {
                takeShot(direction);
            }
        }
    }
    private void takeShot(String direction) {
        shotsTaken++;
        goalkeeperMove = random.nextInt(3);
        playerShot = 0;

        switch (direction) {
            case "left":
                break;
            case "center":
                playerShot = 1;
                break;
            case "right":
                playerShot = 2;
                break;
        }


        isBallMoving = true;
        isGkMoving = true;


        startBallMovement(playerShot);
        startGoalkeeperMovement(goalkeeperMove);
        if (shotsTaken == MAX_SHOTS) {
            disableButtons();
            displayFinalResult();
        }
    }

    private void startBallMovement(int direction) {
        ballTimer = new Timer(10, e -> {
            if (isBallMoving) {
                ballY -= 5;

                if (direction == 0) {
                    ballX -= 3;
                } else if (direction == 2) {
                    ballX += 3;
                }


                if (ballY <= 200) {
                    isBallMoving = false;
                    ((Timer) e.getSource()).stop();
                    checkGoal();
                }
                repaint();
            }
        });
        ballTimer.start();
    }

    private void startGoalkeeperMovement(int direction) {
        gkTimer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isGkMoving) {
                    if (direction == 0) {
                        gkX -= 3;
                    } else if (direction == 2) {
                        gkX += 3;
                    }


                    if (gkX <= 200 || gkX >= 400) {
                        isGkMoving = false;
                        ((Timer) e.getSource()).stop();
                    }
                    repaint();
                }
            }
        });
        gkTimer.start();
    }

    private void checkGoal() {
        if (goalkeeperMove == playerShot) {
            resultMessage.setText("Miss! Goalkeeper saved the shot!");
            goalsSaved++;
        } else {
            resultMessage.setText("Goal!");
            goalsScored++;
        }

        scorelbl.setText("Goals Scored: " + goalsScored + "   Goals Missed: " + goalsSaved);
        ballX = 375;
        ballY = 600;
        gkX = 300;
        gkY = 150;

        repaint();
        if(shotsTaken==MAX_SHOTS){
            displayFinalResult();
        }

    }

    private void disableButtons() {
        leftBtn.setEnabled(false);
        ctrBtn.setEnabled(false);
        rightBtn.setEnabled(false);
    }

    private void displayFinalResult() {
        String winner = (goalsScored > goalsSaved) ? "You Win!" : (goalsScored < goalsSaved) ? "You Lose!" : "It's a Tie!";
        scorelbl.setText("<html>Final Score: Goals Scored: " + goalsScored +
                " | Goals Missed: " + goalsSaved + "<br>" + winner + "</html>");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Penalty Shootout Game");
            PenaltyShootout panel = new PenaltyShootout();

            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
}
