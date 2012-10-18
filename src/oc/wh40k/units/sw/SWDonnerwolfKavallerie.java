package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class SWDonnerwolfKavallerie extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsZaehlerGruppe o3;

	public SWDonnerwolfKavallerie() {
		name = "Donnerwolf-Kavallerie\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Donnerwolf-Reiter", 1, 5, 50);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWDonnerwolfKavallerie.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Wolfsklaue", 20));
		ogE.addElement(new OptionsGruppeEintrag("Frostklinge", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "1 x Mal des Wulfen", 5));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o3.setMaxAnzahl(squad.getModelle());
	}

}
