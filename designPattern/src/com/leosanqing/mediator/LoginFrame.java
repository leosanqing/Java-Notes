package com.leosanqing.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: leosanqing
 * @Date: 2019-10-28 08:14
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckBox checkGuest;
    private ColleagueCheckBox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPassword;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(4, 2));
        createColleagues();

        add(checkGuest);
        add(checkLogin);
        add(new Label("username"));
        add(textUser);
        add(new Label("Password"));
        add(textPassword);
        add(buttonOk);
        add(buttonCancel);

        colleagueChanged();
        pack();
        setVisible(true);
    }


    // 生成各个Colleague
    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckBox("Guest",g,true);
        checkLogin = new ColleagueCheckBox("Login",g,false);
        textUser = new ColleagueTextField("",10);
        textPassword = new ColleagueTextField("",10);
        textPassword.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // 设置Mediator
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textPassword.setMediator(this);
        textUser.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // 设置Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPassword.addTextListener(textPassword);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if(checkGuest.getState()){
            textUser.setColleagueEnabled(false);
            textPassword.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        }else{
            textUser.setColleagueEnabled(true);
            userPasswordChanged();
        }
    }

    private void userPasswordChanged() {
        if(textUser.getText().length()>0){
            textPassword.setColleagueEnabled(true);
            if(textPassword.getText().length()>0){
                buttonOk.setColleagueEnabled(true);
            }else {
                buttonOk.setColleagueEnabled(false);
            }
        }else{
            textPassword.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }
}
