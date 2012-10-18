package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class EDVendettaGunshipSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe1x;
	OptionsEinzelZaehler oe2;

	public EDVendettaGunshipSquadron() {
		name = "Vendetta Gunship Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vendetta gunship", "Vendetta gunships", 1, 3, 130);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

		seperator();

		add(oe1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Two lascannons", "Two twin-linked lascannons", 3, 0));
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Two Hellfury missiles", 3, 0));

        seperator(5);

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Heavy bolters", "Two sponsons with Heavy bolters", 3, 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
		oe1x.setMaxAnzahl(squad.getModelle());
		oe1x.setAnzahl(oe1x.getMaxAnzahl() - oe1.getAnzahl());
		oe2.setMaxAnzahl(squad.getModelle());
	}

}
