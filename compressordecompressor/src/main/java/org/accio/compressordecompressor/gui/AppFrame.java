package org.accio.compressordecompressor.gui;

import org.accio.compressordecompressor.comp_decomp.Compressor;
import org.accio.compressordecompressor.comp_decomp.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;//declaration of button for compressing
    JButton decompressButton;

    JLabel label;

    public AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label=new JLabel();
        label.setText("Compressor & Decompressor");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setForeground(new Color(0,20,230));
        label.setBounds(120, 80, 460, 20);
        label.setFont(new Font("MV Boli",Font.PLAIN,20));
        this.add(label);
//        JPanel panel = new JPanel();
//        panel.add(label);
//        panel.setBackground(Color.gray);
//        panel.setBounds(20, 20, 360, 20); // set the position and size of the panel
//        this.add(panel); // add the panel to the window

        compressButton = new JButton("Select file to compress");//initialising buttons with title passed
        compressButton.setBounds(20, 170, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(260, 170, 200, 30);
        decompressButton.addActionListener(this);

        this.setTitle("CompressorDecompressor");
        this.add(compressButton); //adding the button to the Jframe
        this.add(decompressButton);
        this.setSize(500,400);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int response = 0;
        if(e.getSource()==compressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int respone = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                    //JOptionPane.showMessageDialog(null,"Your file is compressed","Greeting",JOptionPane.PLAIN_MESSAGE);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null , ex.toString());
                }
            }
        }
        if(e.getSource()==decompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int respone = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null , ex.toString());
                }
            }
        }

    }
}
