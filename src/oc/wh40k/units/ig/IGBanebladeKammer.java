package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IGBanebladeKammer extends RuestkammerVater {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsUpgradeGruppe o4;
	OptionsUpgradeGruppe o5;
	OptionsEinzelUpgrade o6;

	public void initButtons(boolean... defaults) {

        //  [0] Befehlspanzer

		name = "Baneblade";
		grundkosten = 0;


		add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));
		

        if (!defaults[0]) add(o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Baneblade", 500));
        else add(o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehls-Baneblade", 500));

        seperator();
                
        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzlicher Sturmbolter", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzliches Maschinengewehr", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		ogE.addElement(new OptionsGruppeEintrag("zus�tzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kommissar","Kommissariats-Besatzung", 25));
		ogE.addElement(new OptionsGruppeEintrag("Befehlspanzer",25));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		sizeSetzen();

	}

	public void refreshen() {
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
            if (!o4.isSelected()) o4.setSelected(0,true);
            o6.setSelected(true);
	}

}
