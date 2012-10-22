package oc.wh30k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class FOImperialeBastion extends Eintrag {
	
	OptionsUpgradeGruppe o1;

	public FOImperialeBastion() {
		name = "Imperiale Bastion";
		grundkosten = 75;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Voxrelais", 20));
		ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone","Waffenstellung mit Icarus-Laserkanone", 35));
		ogE.addElement(new OptionsGruppeEintrag("Vierlings-Flak","Waffenstellung mit Vierlings-Flak", 50));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}
}