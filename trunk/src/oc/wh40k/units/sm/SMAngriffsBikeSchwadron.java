package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class SMAngriffsBikeSchwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTrike;

	public SMAngriffsBikeSchwadron() {
		name = "Angriffs-Bike-Schwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines auf Bike", 4, 8, 25);
		add(squad);
		squad.setModelle(5);

		add(ico = new oc.Picture("oc/wh40k/images/SMAngriffsBikeSchwadron.jpg"));

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
		rkTrike.setToolTipText("Wenn nur 4 normale Biker gewählt wurden, muss diese Option gewählt werden. Die Schwadron MUSS aus mindestens 5 Modellen bestehen.");
		add(rkTrike);

		// This Sarge may only change ONE weapon
		rkBoss.getKammer().switchEntry("BikeSarge", true);

		complete();

	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		if (squad.getModelle() == 4) {
			rkTrike.setAbwaehlbar(false);
		} // muss aus mindestens 5 Modellen bestehen
		else {
			rkTrike.setAbwaehlbar(true);
		}
	}

}

