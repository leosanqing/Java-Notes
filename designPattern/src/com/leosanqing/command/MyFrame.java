package com.leosanqing.command;

import com.leosanqing.command.command.Command;
import com.leosanqing.command.command.MacroCommand;
import com.leosanqing.command.drawer.DrawCanvas;
import com.leosanqing.command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.event.*;

/**
 * @Author: leosanqing
 * @Date: 2019-09-22 11:33
 */
public class MyFrame extends JFrame implements ActionListener,
        MouseMotionListener, WindowListener {
    private MacroCommand history = new MacroCommand();

    private DrawCanvas canvas = new DrawCanvas(400,400,history);

    private JButton clearButton = new JButton("clear");

    public MyFrame(String title){
        super(title);

        this.addWindowListener(this);
        this.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            history.clear();
            canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("15646546465");
        Command command = new DrawCommand(canvas,e.getPoint());
        history.append(command);
        command.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println(e.getPoint());
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
