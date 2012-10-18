package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ELGardisten extends Eintrag {

	AnzahlPanel Gardisten;
	OptionsEinzelUpgrade boss;
	RuestkammerStarter rüstkammer;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oo1;
	OptionsZaehlerGruppe oo2;
	RuestkammerStarter Serpent;

	public ELGardisten() {
		name = "Gardisten";
		grundkosten = 0;

		Gardisten = new AnzahlPanel(ID, randAbstand, cnt, "Gardisten", 10, 20, 8);
		add(Gardisten);

		add(ico = new oc.Picture("oc/wh40k/images/ELGardisten.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 30));
		ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 25));
		o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE);
		add(o1);
		seperator();

		oo1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmgardisten", 0);
		add(oo1);
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fusionsstrahler", 6));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 6));
		oo2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2);
		add(oo2);

		seperator();

		rüstkammer = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser");
		rüstkammer.initKammer(false, false);
		add(rüstkammer);
		seperator();

		Serpent = new RuestkammerStarter(ID, randAbstand, cnt, "ELSerpentKammer", "Serpent");
		Serpent.initKammer();
		add(Serpent);
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		if (oo1.isSelected()) {
			o1.setAktiv(false);
			oo2.setAktiv(true);
			ico.setIcon("oc/wh40k/images/ELSturmGardisten.jpg");
		} else {
			ico.setIcon("oc/wh40k/images/ELGardisten.jpg");
			o1.setAktiv(true);
			oo2.setAktiv(false);
		}
		
		if(!o1.isSelected()) o1.setSelected(0, true);

		Serpent.setAktiv(Gardisten.getModelle() <= 12); // only available if max. 12 models
		
		Serpent.getPanel().setLocation((int) Serpent.getPanel().getLocation().getX(), (int) rüstkammer.getPanel().getLocation().getY() + rüstkammer.getPanel().getSize().height + 3);
	}
	
}
