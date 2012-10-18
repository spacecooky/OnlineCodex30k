package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;

public class EDTaurosVenatorSquadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe1x;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsEinzelZaehler oe4;
    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;

	public EDTaurosVenatorSquadron() {
		name = "Tauros Venator Squadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Tauros Venator", "Tauros Venators", 1, 3, 50);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGVendettaGunshipSquadron.jpg"));

		seperator();

		add(oe1x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Multi-laser", "Twin-linked Multi-laser", 3, 0));
		add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Lascannon", "Twin-linked Lascannons", 3, 15));

        seperator(5);

		add(oe2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Hunter-killer missile", 6, 10));
		add(oe3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Extra armour", 3, 15));
		add(oe4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "Homing beacon", 3, 20));

        seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Smoke launchers", 5));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Camo netting", 10));

        complete();
	}

	@Override
	public void refreshen() {
		oe1.setMaxAnzahl(squad.getModelle());
		oe1x.setMaxAnzahl(squad.getModelle());
		oe1x.setAnzahl(oe1x.getMaxAnzahl() - oe1.getAnzahl());
		oe2.setMaxAnzahl(squad.getModelle() * 2);
		oe3.setMaxAnzahl(squad.getModelle());
		oe4.setMaxAnzahl(squad.getModelle());

        o1.setPreis(squad.getModelle() * 5);
        o2.setPreis(squad.getModelle() * 10);
	}

}
