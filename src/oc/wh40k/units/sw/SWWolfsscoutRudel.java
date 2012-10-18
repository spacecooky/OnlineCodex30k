package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SWWolfsscoutRudel extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsEinzelUpgrade mb;

	public SWWolfsscoutRudel() {
		name = "Wolfsscout-Rudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolfsscouts", 5, 10, 15);
		add(squad);
		
		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWWolfscoutrudel.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengewehr", 3));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "1 x Mal des Wulfen", 15));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - o3.getAnzahl());
		mb.setPreis(squad.getModelle() * 5);
	}

}
