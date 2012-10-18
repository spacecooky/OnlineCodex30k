package oc;import java.awt.Color;import java.util.Vector;import javax.swing.JLabel;import javax.swing.JOptionPane;import javax.swing.JPanel;import javax.swing.JTextArea;import javax.swing.JTextField;public abstract class BuildaPanel implements BuildaSTK{  // Die Vaterklasse f�r alle anderen OC-Klassen, da jede oC Klasse ein wei�es JPanel brauch^^	public static int game;	public static int WH40K = 0;	public static int WHFB = 1;	public static String reflectionKennung = ""; // wird vor jeden Klassennamen, der im chooser ausgew�hlt wird, drangeh�ngt	public static String reflectionKennungAllies = ""; // wird vor jeden Klassennamen, der im chooser ausgew�hlt wird, drangeh�ngt	public static Vector<String> noAllies = new Vector<String>(); 	public static String nameDerArtDerArmee = "";	protected JPanel panel = new JPanel(null,false); // kein LayoutManager f�r ALLE Panels, aber doubleBuffered	public BuildaVater myBuilder;	public static JTextField budget = new JTextField();	public final JLabel kostenLabel = new JLabel();	public static JTextArea textArea = new JTextArea();		public JPanel getPanel(){		return this.panel;	}		static String getReflectionKennungAllies(){		return reflectionKennungAllies;	}		static void setReflectionKennungAllies(String s){		reflectionKennungAllies = s;	}		public int getHoehe(){		return panel.getSize().height;	}	public String entferneNullNachkomma(double kosten){		String tmp = "";		try{			tmp = String.valueOf(kosten);			if(tmp.endsWith(".0")){				tmp = tmp.substring(0,tmp.length()-2);			}					}catch(Exception e){ }				return tmp;	}	public BuildaPanel(){		panel.setBackground(Color.WHITE);	} // jedes Panel was ich benutze hat einen wei�en Hintergrund		public RefreshListener refreshListener = new RefreshListener((byte) 15) {		public void refresh() {			if (getKosten() != 0) {				kostenLabel.setText(BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Pkt."));				try {					if(getGame() == WHFB && (budget.getText().equals("") || getKosten() > Integer.valueOf(budget.getText()))){						kostenLabel.setForeground(Color.RED);					}else{						kostenLabel.setForeground(Color.BLACK);					}				} catch (NumberFormatException e) {					JOptionPane.showMessageDialog(null, BuildaHQ.translate("Bitte nur Zahlen eingeben."));				}			} else {				kostenLabel.setText("");			}		}	};		public double getKosten() {		return myBuilder.getKosten();	}		public static void setGame(int game) {		BuildaPanel.game = game;	}	public static int getGame() {		return BuildaPanel.game;	}    public static String getFileSuffix() {        String suffix = new String();        switch (BuildaPanel.getGame()) {            case 0: // Wh40k            case 3: // Wh40k Legacy            case 5: // Wh40k FanDex                suffix = "ock";                break;            case 1: // WHFB            case 4: // WHFB Legacy                suffix = "ocf";                break;            case 2: // Necromunda                suffix = "ocn";                break;            default:                suffix = "oc";                break;        }        return suffix;    }}