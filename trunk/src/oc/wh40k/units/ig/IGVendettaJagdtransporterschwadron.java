package oc.wh40k.units.ig;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class IGVendettaJagdtransporterschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;

	public IGVendettaJagdtransporterschwadron() {
		name = "Vendetta-Jagdtransporterschwadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vendetta", "Vendettas", 1, 3, 130);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Höllenfeuerraketen", "Paar Höllenfeuerraketen", 3, 0));
		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Schwere Bolter", "Paar schwere Bolter", 3, 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
		oe2.setMaxAnzahl(squad.getModelle());
	}

}
