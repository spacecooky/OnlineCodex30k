package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMBikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTrike;

	public SMBikeSchwadron() {
		name = "Bike-Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines auf Bike", 3, 8, 25);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/Bikeschwadron.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true, false);
		rkBoss.setGrundkosten(15);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTrike = new RuestkammerStarter(ID, randAbstand, cnt, "SMTrike", "Trike");
		rkTrike.initKammer();
		add(rkTrike);

		// This Sarge may only change ONE weapon
		rkBoss.getKammer().switchEntry("BikeSarge", true);

		complete();
	}

	@Override
	public void refreshen() {
		if(!rkBoss.isSelected()) rkBoss.setSelected(true);
		
		rkTrike.getPanel().setLocation(
			(int) rkTrike.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}

}

