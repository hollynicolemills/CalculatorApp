import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateButton {
		JButton name;
		
		public CreateButton(String symbol, ActionListener listener, JPanel pane) {
			name = new JButton(symbol);
			name.addActionListener(listener);
			name.setActionCommand(symbol);
			pane.add(name);
		}
	}
