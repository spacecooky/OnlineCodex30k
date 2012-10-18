package oc;import java.awt.Color;import java.awt.Component;import java.awt.Font;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.util.HashMap;import java.util.Vector;import javax.swing.JButton;import javax.swing.JComboBox;import javax.swing.JList;import javax.swing.ListCellRenderer;import org.w3c.dom.Element;public class Chooser extends BuildaPanel implements ActionListener, BuildaSTK {    private static ListCellRenderer defaultRenderer = new JComboBox().getRenderer(); // mein eigener Renderer "überschreibt" sozusagen den default renderer, indem er seine Methode aufruft und das reurnte verändert. Dafür muss ich diesen aber einmal haben    private JComboBox myComboBox = new JComboBox();    public JComboBox getMyComboBox() {    return myComboBox;    }    public void setMyComboBox(JComboBox myComboBox) {    this.myComboBox = myComboBox;    }    private JButton cloneButton = new JButton(BuildaHQ.translate("Clonen"));    private String reflectionKennung;    private String reflectionKennungAllies;    String allyString="";    private Object[] statischeEinträge;    private Vector<String> spezialEinträge;    private Vector<String> allyEinträge;    private Vector<String> allySpezialEinträge;    private int kategorie;    private boolean useActionPerformed = true;    private Eintrag myEintrag = null;// = new LeererEintrag(0,0);    private HashMap<String, String> multipleArmyClasses = new HashMap<String, String>();    public int getKategorie() {    return this.kategorie;    }    public Eintrag getEintrag() {    return this.myEintrag;    }    public JButton getCloneButton() {    return cloneButton;    }    public JComboBox getComboBox() {    return this.myComboBox;    }    public double getKosten() {    try {      return ((Eintrag) myEintrag).getKosten();    } catch (Exception e) {      return 0;    }    }    public Chooser setStatischeEinträge(Object[] sE) {    this.statischeEinträge = sE;    return this;    } // muss extra gemacht werden, weil als Parameter dem Kosntruktor auch alle Spezialauswahlen mitgegeben werden, ich aber für den Renderer die Info brauch was statisch ist...    public Chooser setSpezialEinträge(Vector<String> sE) {        this.spezialEinträge = sE;        return this;        }        public Chooser setAllyEinträge(Vector<String> sE) {        this.allyEinträge = sE;        return this;        }        public Chooser setAllySpezialEinträge(Vector<String> sE) {        this.allySpezialEinträge = sE;        return this;        }        public Chooser(int lX, int lY, String reflectionKennung, String reflectionKennungAllies, Object[] alleEinträge, int kategorie, ActionListener cloneListener) {  // ACHTUNG: wenn mehr oder weniger als 2 Hauptsachen zum panel geaddet werden, muss aktuellenEintragLöschen geändert werden! weil dann der index falsch ist, an dem irgendwas ins panel geaddet ist.    this.kategorie = kategorie;    this.panel.setLocation(lX, lY);    this.reflectionKennung = reflectionKennung;    this.reflectionKennungAllies = reflectionKennungAllies;    myComboBox = new JComboBox(alleEinträge);    myComboBox.setBounds(0, 0, auswahlBreite - 60, 20);    myComboBox.addActionListener(this);    myComboBox.setFocusable(false); // sie hat nie den Focus und wird deshalb nie durch die Pfeil-Unten-Taste geöffnet    BuildaHQ.newGUIComponent(myComboBox);    myComboBox.setBackground(Color.WHITE);    //myComboBox.setMaximumRowCount(25);    //System.out.println((BILDSCHIRMHÖHE-100)/20);    myComboBox.setMaximumRowCount((BILDSCHIRMHÖHE-150)/20);    myComboBox.setEditable(false);    myComboBox.setRenderer(renderer);    myComboBox.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);    //myComboBox.setEditable(true); Lustig!^^ man kann den ausgewählten Namen direkt eingeben. Mit enter lädt der entsprechende Eintrag auch! d.h. Carnifexe, Todesboten und Land Raider gleichzeitig^^ die laden/speichern Funktion funktioniert dabei sogar!    panel.add(myComboBox);    cloneButton.setBounds(auswahlBreite - 55, 0, 65, 20);    cloneButton.addActionListener(cloneListener);    BuildaHQ.newGUIComponent(cloneButton);    cloneButton.setBorder(BuildaHQ.createBorder(new Color(134, 201, 218)));    cloneButton.setFont(new Font("tahoma", Font.PLAIN, 12));    cloneButton.setToolTipText("Clont diesen Eintrag mit all seinen Einstellungen und Rüstkammern.");    panel.add(cloneButton);    // panel.add V_O_R_S_I_C_H_T! siehe eintragLöschen    sizeSetzen();    cloneButton.repaint();    panel.repaint();    new RefreshListener((byte) 9) {      @Override      public void refresh() {        sizeSetzen();      }  // guckstu ende erstelleEintrag()  wenn du das hier ämndern willst    };    }    ListCellRenderer renderer = new ListCellRenderer() {    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {      Component c = defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);            for (int i = 0; i < statischeEinträge.length; ++i) {        if (statischeEinträge[i].equals(value)) {        	c.setForeground(new Color(0, 0, 0));          break;        }      }            for (int i = 0; i < allyEinträge.size(); ++i) {          if (allyEinträge.get(i).equals((String)value)) {          	c.setForeground(new Color(30, 0, 205));            break;          }        }            for (int i = 0; i < spezialEinträge.size(); ++i) {          if (spezialEinträge.get(i).equals((String)value)) {          	c.setForeground(new Color(30, 205, 0));            break;          }        }            for (int i = 0; i < allySpezialEinträge.size(); ++i) {          if (allySpezialEinträge.get(i).equals((String)value)) {          	c.setForeground(new Color(205, 105, 0));            break;          }        }      return c;    }    };    public void sizeSetzen() {    int x = myComboBox.getSize().width;    int y = myComboBox.getSize().height;    if (myEintrag != null) {      x = BuildaHQ.wasIstHoeher(x, ((Eintrag) myEintrag).getBreite());      y = ((Eintrag) myEintrag).getHöhe();      x += ((Eintrag) myEintrag).getPanel().getLocation().getX();      y += ((Eintrag) myEintrag).getPanel().getLocation().getY();    }    panel.setSize(x, y + randAbstand);    }    @SuppressWarnings("unchecked")    public void setAuswahlen(Vector v) {    useActionPerformed = false;    String currentSelected = selectedEntry();    // leeren und neufüllen der Liste    myComboBox.removeAllItems();    for (int i = 0; i < v.size(); ++i) {      myComboBox.addItem(v.elementAt(i));    }    myComboBox.setSelectedItem(currentSelected);    if (!selectedEntry().equals(currentSelected)) {      myEintrag.deleteYourself();    } //  myEintrag hat sich bis jetzt noch nicht geändert, weil ich useActionPerformed auf false geschaltet hab.    useActionPerformed = true;    }    @SuppressWarnings("unchecked")    public void erstelleEintrag(String name) {	    String umgeformterName = BuildaHQ.formZuKlassenName(name);    allyString=allyString.trim();    //System.out.println(allyString);    if (umgeformterName.equals("")) {      erstelleLeerenEintrag();    } else if(!allyString.equals("") && umgeformterName.contains(allyString)){    	String finalClassNameAllies = "";    	try {            // Determine whether to use a WHFB or a Wh40k Army-Class            String armyPackage = OnlineCodex.armyPackage;            // Check if the requested class is used by multiple armies            if (this.multipleArmyClasses.containsKey(name)) {            	finalClassNameAllies = this.multipleArmyClasses.get(name);            } else {              finalClassNameAllies = reflectionKennungAllies + umgeformterName;            }            finalClassNameAllies = finalClassNameAllies.replaceAll("\\[[\\w ]{1,}\\]", ""); // Remove "Forgeworld" label from class name            try {              Class myClass = Class.forName(armyPackage + "units." + finalClassNameAllies);                          aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...              myEintrag = (Eintrag) (myClass.newInstance());            } catch (Exception e) {                              try {                                    Class myClass = Class.forName(armyPackage + "units." + reflectionKennungAllies.toLowerCase() + "." + finalClassNameAllies);                  aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...                  myEintrag = (Eintrag) (myClass.newInstance());                                } catch(Exception ex) {                                        Class myClass = Class.forName(armyPackage + "units." + umgeformterName);                                    aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...                                    myEintrag = (Eintrag) (myClass.newInstance());                                        }            }            if (umgeformterName.startsWith("Requiriert")) {              myEintrag.setName(name); // Requirierte Einheiten            }            myEintrag.getPanel().setLocation(0, 30);            myEintrag.setKategorie(kategorie);            panel.add(myEintrag.getPanel());          } catch (ClassNotFoundException e) {            OnlineCodex.getInstance().fehler("Klasse \"" +finalClassNameAllies + "\" nicht gefunden.\nBitte melden!!");            System.out.println("Klasse \"" + finalClassNameAllies + "\" nicht gefunden. Bitte melden!!");            erstelleLeerenEintrag();            System.out.println(e.getStackTrace());          } catch (ClassCastException e) {            System.out.println(e.toString());          } catch (InstantiationException e) {            System.out.println(e.toString());          } catch (IllegalAccessException e) {            System.out.println(e.toString());          }    }else{    	String finalClassName = "";      try {        // Determine whether to use a WHFB or a Wh40k Army-Class        String armyPackage = OnlineCodex.armyPackage;        // Check if the requested class is used by multiple armies        if (this.multipleArmyClasses.containsKey(name)) {          finalClassName = this.multipleArmyClasses.get(name);        } else {          finalClassName = reflectionKennung + umgeformterName;        }        finalClassName = finalClassName.replaceAll("\\[[\\w ]{1,}\\]", ""); // Remove "Forgeworld" label from class name        try {          Class myClass = Class.forName(armyPackage + "units." + finalClassName);                  aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...          myEintrag = (Eintrag) (myClass.newInstance());        } catch (Exception e) {                      try {                            Class myClass = Class.forName(armyPackage + "units." + reflectionKennung.toLowerCase() + "." + finalClassName);              aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...              myEintrag = (Eintrag) (myClass.newInstance());                        } catch(Exception ex) {                                Class myClass = Class.forName(armyPackage + "units." + umgeformterName);                            aktuellenEintragLöschen(); // wird auch in erstelleLeerenEintrag() aufgerufen...                            myEintrag = (Eintrag) (myClass.newInstance());                                   }        }        if (umgeformterName.startsWith("Requiriert")) {          myEintrag.setName(name); // Requirierte Einheiten        }        myEintrag.getPanel().setLocation(0, 30);        myEintrag.setKategorie(kategorie);        panel.add(myEintrag.getPanel());      } catch (ClassNotFoundException e) {        OnlineCodex.getInstance().fehler("Klasse \"" + finalClassName+ "\" nicht gefunden.\nBitte melden!!");        System.out.println("Klasse \"" + finalClassName+"\" nicht gefunden. Bitte melden!!");        erstelleLeerenEintrag();        System.out.println(e.getStackTrace());      } catch (ClassCastException e) {        System.out.println(e.toString());      } catch (InstantiationException e) {        System.out.println(e.toString());      } catch (IllegalAccessException e) {        System.out.println(e.toString());      }    }    RefreshListener.fireRefresh();  // fireRefresh macht SizeSetzen()    cloneButton.setVisible(!(myEintrag instanceof LeererEintrag));    }    public String selectedEntry() {    return ((String) (myComboBox.getSelectedObjects()[0]));    }    public void actionPerformed(ActionEvent event) {    if (useActionPerformed) {      erstelleEintrag(selectedEntry());    }    }    public void aktuellenEintragLöschen() {    if (myEintrag != null) {      myEintrag.deleteYourself();      RefreshListener.remove(myEintrag.getID());      myEintrag = null;      try {        panel.remove(2);      } catch (Exception e) {        e.printStackTrace();      }  // zahl ändern wenn mehr oder weniger Components aufem Panel sind!    }    }    public void erstelleLeerenEintrag() {    aktuellenEintragLöschen();    myEintrag = new LeererEintrag(0, 0);    myEintrag.getPanel().setLocation(0, 30);    panel.add(myEintrag.getPanel());    }    public String getText() {    try {      return myEintrag.getText();    } catch (Exception e) {      return "";    }    }    public String getSaveText(String trenner) {    try {      return myEintrag.getSaveText(trenner);    } catch (Exception e) {      return "";    }    }    public Element getSaveElement() {          if(getComboBox().getSelectedObjects()[0].toString().trim().equals("")) return null;          Element root = myEintrag.getSaveElement();          root.setAttribute("selection", getComboBox().getSelectedObjects()[0].toString());//          Element root = BuildaHQ.getNewXMLElement("Eintrag");//          root.setAttribute("selection", getComboBox().getSelectedObjects()[0].toString());//    //          root.appendChild(myEintrag.getSaveElement());          return root;    }    public void load(String s, String s2) {        myEintrag.load(s, s2);    }        public void loadElement(Element e) {        myEintrag.loadElement(e);    }}