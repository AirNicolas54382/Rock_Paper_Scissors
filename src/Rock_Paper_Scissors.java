import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Rock_Paper_Scissors implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    JPanel panel = new JPanel();

    JLabel panel2 = new JLabel();
    JButton Rock = new JButton();
    JButton Scissors = new JButton();
    JButton Paper = new JButton();
    ImageIcon icon = new ImageIcon("rock.png");
    ImageIcon icon2 = new ImageIcon("paper.png");
    ImageIcon icon3 = new ImageIcon("scissors.png");

    Random generator = new Random();

    int move;
    int opponent_move;
    int win;

    int player_score = 0;
    int opponent_score = 0;
    //-----------------------------------
    JFrame frame2 =new JFrame();

    JPanel panel_ = new JPanel();
    JLabel label_icon = new JLabel();

    JLabel label_ = new JLabel();
    JLabel endlabel_ = new JLabel();

    ImageIcon opponent_icon = new ImageIcon("scissors.png");

    JLabel score = new JLabel();

    JButton Return = new JButton();


    Rock_Paper_Scissors(){

        //frame
        panel.setBackground(Color.darkGray);
        panel.setLayout(new GridLayout(2,1,50,0));

        label.setText("What is your move?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN,35));
        label.setForeground(Color.WHITE);


        Rock.setIcon(icon);
        Paper.setIcon(icon2);
        Scissors.setIcon(icon3);
        Rock.setBounds(0,0,72,152);
        Paper.setBounds(0,0,72,152);
        Scissors.setBounds(0,0,72,152);
        Rock.setBackground(Color.gray);
        Paper.setBackground(Color.gray);
        Scissors.setBackground(Color.gray);
        Rock.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        Paper.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        Scissors.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        Rock.addActionListener(this);
        Paper.addActionListener(this);
        Scissors.addActionListener(this);


        panel2.setBackground(Color.darkGray);
        panel2.setLayout(new GridLayout(1,3));
        panel2.setOpaque(true);

        panel.add(label);
        panel.add(panel2);
        panel2.add(Rock);
        panel2.add(Paper);
        panel2.add(Scissors);
        frame.add(panel);
        frame.setSize(600,400);
        frame.setVisible(true);

        //frame2
        panel_.setBackground(Color.darkGray);
        panel_.setLayout(new GridLayout(3,1,50,0));

        label_.setText("Opponent move:");
        label_.setHorizontalAlignment(SwingConstants.CENTER);
        label_.setVerticalAlignment(SwingConstants.CENTER);
        label_.setFont(new Font("Serif", Font.PLAIN,35));
        label_.setForeground(Color.WHITE);

        label_icon.setIcon(opponent_icon);
        label_icon.setHorizontalAlignment(SwingConstants.CENTER);
        label_icon.setVerticalAlignment(SwingConstants.CENTER);

        score.setText("0:0");
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("Serif", Font.PLAIN,35));
        score.setForeground(Color.WHITE);

        endlabel_.setLayout(new GridLayout(2,1));

        Return.addActionListener(this);
        Return.setText("Return");
        Return.setFont(new Font("Serif", Font.PLAIN,35));

        endlabel_.add(score);
        endlabel_.add(Return);
        panel_.add(label_);
        panel_.add(label_icon);
        panel_.add(endlabel_);
        frame2.add(panel_);
        frame2.setSize(600,400);
        frame2.setVisible(false);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Return){
            frame2.setVisible(false);
            frame.setVisible(true);
        }else {
            frame.setVisible(false);
            frame2.setVisible(true);

            if (e.getSource() == Rock) {
                move = 0;
            } else if (e.getSource() == Paper) {
                move = 1;
            } else if (e.getSource() == Scissors) {
                move = 2;
            }
            opponent_move = generator.nextInt(3);

            switch (opponent_move){
                case 0:
                    label_icon.setIcon(icon);
                    break;
                case 1:
                    label_icon.setIcon(icon2);
                    break;
                case 2:
                    label_icon.setIcon(icon3);
                    break;
            }




            if (move == 0 && opponent_move == 0) {
                win = 2;    //0 - win ; 1 - lose ; 2- remis
            } else if (move == 0 && opponent_move == 1) {
                win = 1;
            } else if (move == 0 && opponent_move == 2) {
                win = 0;
            } else if (move == 1 && opponent_move == 0) {
                win = 0;
            } else if (move == 1 && opponent_move == 1) {
                win = 2;
            } else if (move == 1 && opponent_move == 2) {
                win = 1;
            } else if (move == 2 && opponent_move == 0) {
                win = 1;
            } else if (move == 2 && opponent_move == 1) {
                win = 0;
            } else {
                win = 2;
            }

            if (win == 0) {
                player_score++;
                score.setText(player_score + ":" + opponent_score);
            } else if (win == 1) {
                opponent_score++;
                score.setText(player_score + ":" + opponent_score);
            } else {
                score.setText(player_score + ":" + opponent_score);
            }
        }
    }
}
