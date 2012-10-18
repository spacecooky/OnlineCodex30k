
package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class BTSturmtrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelZaehler oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;

	public BTSturmtrupp() {
		name = "Sturmtrupp";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sturm Marines", 5, 10, 22);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTSturmtrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 5));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 6));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmschild", 0, 15));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Sprenggranaten", 0));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melterbomben", 0));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
		oe2.setPreis(squad.getModelle());
		oe3.setPreis(squad.getModelle() * 2);
	}

}
