//2020/6/11 陳昭潔U10616001
//主視窗
//3-tier:UI

package javafinal;

import javax.swing.*;
import java.awt.*;

public class GoodLifeFinal extends JFrame {
	Register register = new Register();
	public GoodLifeFinal() { //將註冊的panel加進來
		add(register);
	}
	public static void main(String[] args) { //設定視窗
		JFrame frame = new GoodLifeFinal();
	    frame.setTitle("Goof Life");
	    frame.setSize(640, 320);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}
}
