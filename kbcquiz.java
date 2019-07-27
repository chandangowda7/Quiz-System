import java.util. * ;
import java.awt. * ;
import java.awt.event. * ;
import javax.swing. * ;
import javax.swing.event. * ;
import java.io. * ;

class q extends JFrame implements ActionListener {
	static int aa[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	String ans;
	int ch;
	static int cor = 0;
	static int v = 0;
	JPanel panel;
	JFrame frame;
	JLabel label;
	JButton submit,next,quit,ins;
	JRadioButton oa,ob,oc,od;
	String q,a,b,c,d,rans;
	int k;
	int i;
	void run() {
		q = "";
		a = "";
		b = "";
		c = "";
		d = "";
		rans = "";
		ans = "";
		ch = 0;
		try {
			Scanner x = new Scanner(new File("quiz.txt"));
			int rno = new Random().nextInt(20);
			System.out.println(rno);
			if (v < 5 && rno != 0) {
				for (int h = 0; h <= v; h++) {
					if (aa[h] == rno) {
						q w = new q();
						w.run();
					}
				}
				aa[v] = rno;
				v++;
				for (int g = 0; g < 10; g++)
				System.out.print(aa[g]);

				k = 0;
				while (rno != k) {
					q = x.nextLine();
					a = x.nextLine();
					b = x.nextLine();
					c = x.nextLine();
					d = x.nextLine();
					rans = x.nextLine();
					k++;
				}
				System.out.println(rans);
				frame = new JFrame("JFrame Example");
				panel = new JPanel();
				panel.setLayout(new FlowLayout());
				label = new JLabel(q);
				panel.add(label);
				frame.add(panel);
				frame.setSize(1580, 390);
				frame.setLocationRelativeTo(null);
				oa = new JRadioButton(a);
				panel.add(oa);
				ob = new JRadioButton(b);
				panel.add(ob);
				oc = new JRadioButton(c);
				panel.add(oc);
				od = new JRadioButton(d);
				panel.add(od);
				submit = new JButton(" Lock This Option");
				panel.add(submit);

				next = new JButton(" Next Question");
				panel.add(next);
				quit = new JButton("Quit This Game");
				panel.add(quit);
				ins = new JButton(" INSRUCTIONS");
				panel.add(ins);

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				ButtonGroup bg = new ButtonGroup();
				bg.add(oa);
				bg.add(ob);
				bg.add(oc);
				bg.add(od);
				oa.addActionListener(this);
				ob.addActionListener(this);
				oc.addActionListener(this);
				od.addActionListener(this);
				submit.addActionListener(this);
				next.addActionListener(this);
				quit.addActionListener(this);
				ins.addActionListener(this);
			}
			else if (rno == 0) {
				q n = new q();
				n.run();
			}
			else {
				JOptionPane.showMessageDialog(null, " CORRECT ANSWER(S)=" + cor + "       WRONG ANSWER(S)=" + (v - cor) + "    PERCENTAGE=  " + (((double) cor / v) * 100));;
				System.exit(0);
			}
		} catch(Exception e) {
			System.out.print("not found");
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == oa) {
			ans = new String(a);
			ch = 1;
		}
		else if (e.getSource() == ob) {
			ans = new String(b);
			ch = 1;
		}
		else if (e.getSource() == oc) {
			ans = new String(c);
			ch = 1;
		}
		else if (e.getSource() == od) {
			ans = new String(d);
			ch = 1;
			System.out.println(ans + ch);
		}
		if (e.getSource() == submit) {
			System.out.println(ch);
			if (ans.equals(rans) && ch == 1) {
				ch = 2;
				cor++;
				JOptionPane.showMessageDialog(null, " CORRECT ONE");
			}
			else if (ch == 1) {
				JOptionPane.showMessageDialog(null, " WRONGLY ANSWERED ");
				q ek = new q();
				ek.run();
			}
			else JOptionPane.showMessageDialog(null, " CHOOSE OPTION ");
		}
		else if (e.getSource() == next) {
			if (ch == 2) {
				q o = new q();
				o.run();
			}
			else JOptionPane.showMessageDialog(null, " please lock option ");
		}
		else if (e.getSource() == quit) {
			JOptionPane.showMessageDialog(null, " you have quit the quiz ");
			JOptionPane.showMessageDialog(null, " correct ans=" + cor + "       wrong answer=" + (v - cor) + "   unanswered is  " + (5 - v));
			System.exit(0);
		}
		else if (e.getSource() == ins) {
			JOptionPane.showMessageDialog(null, "*'five questions only' *Should answer the question to go to next question *if user sees the question before quitting then also answer is taken as incorrect");
		}
	}
}
class kk {
	public static void main(String args[]) {
		q p = new q();
		p.run();
	}
}