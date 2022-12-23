package com.company.game.Views;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    public About(){
        JLabel label = new JLabel("игра создана с душой. И есть какое то описание", SwingConstants.CENTER);
        setBounds(0,0, 400,200);
        add(label);
    }
}
