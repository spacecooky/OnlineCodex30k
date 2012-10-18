package oc.whfb.units.bdc;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class BDCGnargorHerde extends Eintrag {

	AnzahlPanel squad;
	JLabel label;
	
	public BDCGnargorHerde() {
		name = BuildaHQ.translate("Gnargor Herde");
		grundkosten = 0;
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gnargor Herde"), 1, 100, 55);
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();
		
		label = new JLabel("");//Quick & Dirty
		label.setBounds(10, 26, buttonBreite + 30, 30);
		label.setForeground(Color.RED);
		label.setFont(new Font("Lucida Blackletter", Font.BOLD, 12));
		panel.add(label);
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
