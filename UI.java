import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class UI implements ActionListener
{
	JFrame frame;
	JPanel panel;
	private JTextField accTF,nameTF,passTF,idTF;
	private Member member;
	public int w=1000,h=750;
	public static void main(String[] args)
	{
		UI ui=new UI();
		ui.ui();
	}

	public UI()
	{
		frame = new JFrame("�Ϯ��]");
		frame.setResizable(false);
		frame.setSize(w, h);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				int result = JOptionPane.showConfirmDialog(frame,
						"�O�_�����{��",
						"ĵ�i",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.YES_OPTION){System.exit(0);}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		switch (Integer.parseInt(e.getActionCommand()))
		{
			case 0:
				frame.remove(panel);
				ui();
				break;
			case 1:
				log_in();
				break;
			case 2:
				sign_up();
				break;
			case 3:
				if(accTF.getText().isBlank()||nameTF.getText().isBlank()||passTF.getText().isBlank()||idTF.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null, "��J�Ȥ��ର��!","ĵ�i",3);
					sign_up();
				}
				member=new Member(accTF.getText(),nameTF.getText(),passTF.getText(),idTF.getText());
				if(member.sign_up()){home();}
				else{sign_up();}
				break;
			case 4:
				if(accTF.getText().isBlank()||nameTF.getText().isBlank()||passTF.getText().isBlank()||idTF.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null, "��J�Ȥ��ର��!","ĵ�i",3);
					sign_up();
				}
				else
				{
					member=new Member(accTF.getText(),nameTF.getText(),passTF.getText(),idTF.getText());
					if(member.sign_up())
					{
						member.sign_up();
						home();
					}
					else
					{
						member.sign_up();
						sign_up();
					}
				}
			default:
				break;
		}
	}
	public void ui()
	{

		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/3,h*3/4));
		//new ImageIcon("user.png")

		JButton log_in = new JButton("�n�J");
		JButton panel_up = new JButton("���U");
		log_in.setActionCommand("1");
		panel_up.setActionCommand("2");
		log_in.addActionListener(this);
		panel_up.addActionListener(this);

		panel.add(log_in);
		panel.add(panel_up);
		frame.add(panel);
		frame.setVisible(true);
	}
	


	public void log_in()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,w/50,h/2));
		//new ImageIcon("user.png")

		JButton confirm = new JButton("�T�{");
		JButton back = new JButton("��^");

		JLabel accLB=new JLabel("�b��");
		JTextField accTF = new JTextField(16);
		JLabel passLB=new JLabel("�K�X");
		JTextField passTF = new JPasswordField(12); // �D����K�X��J�F
		
		panel.add(accLB);
		panel.add(accTF);
		panel.add(passLB);
		panel.add(passTF);
		
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void sign_up()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout());
		//new ImageIcon("user.png")

		JButton confirm = new JButton("�T�{");
		JButton back = new JButton("��^");

		JLabel nameLB=new JLabel("�m�W");
		nameTF = new JTextField(16);
		JLabel idLB=new JLabel("����");
		idTF = new JTextField(16);
		JLabel accLB=new JLabel("�b��");
		accTF = new JTextField(16);
		JLabel passLB=new JLabel("�K�X");
		passTF = new JPasswordField(12); // �D����K�X��J�F
		panel.add(accLB);
		panel.add(accTF);
		panel.add(nameLB);
		panel.add(nameTF);
		panel.add(passLB);
		panel.add(passTF);
		panel.add(idLB);
		panel.add(idTF);

		confirm.setActionCommand("4");
		back.setActionCommand("0");
		confirm.addActionListener(this);
		back.addActionListener(this);

		panel.add(confirm);
		panel.add(back);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public void home()
	{
		frame.remove(panel);
		panel= new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER,w/50,h/4));
		
		JButton sear = new JButton("���y�d��");
		JButton returnBook = new JButton("�ٮ�");
		JButton inform = new JButton("�ӤH��T");
		JButton history = new JButton("���v����");
		JButton manaBook = new JButton("���y�޲z");
		JButton fee = new JButton("ú�ǻ@��");
		
		sear.setActionCommand("4");
		returnBook.setActionCommand("5");
		inform.setActionCommand("6");
		history.setActionCommand("7");
		manaBook.setActionCommand("8");
		fee.setActionCommand("9");
		sear.addActionListener(this);
		returnBook.addActionListener(this);
		inform.addActionListener(this);
		history.addActionListener(this);
		manaBook.addActionListener(this);
		fee.addActionListener(this);

		panel.add(sear);
		panel.add(returnBook);
		panel.add(inform);
		panel.add(history);
		if(member.getIdentity().equals("Admin"))
		{
			panel.add(manaBook);
			panel.add(fee);
		}
		frame.add(panel);
		frame.setVisible(true);
	}
}