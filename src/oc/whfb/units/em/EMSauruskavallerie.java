package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSauruskavallerie extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBanner;
	
	private boolean initDone = false;

	public EMSauruskavallerie() {
		name = BuildaHQ.translate("Sauruskavallerie");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Sauruskavallerie"), 5, 100, 35);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/EMSauruskavallerie.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "EMBanner", "");
		rkBanner.initKammer(false, true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	private void checkKategorie() {
		if(getKategorie() == 3) {
			BuildaHQ.addToInformationVector("EMSauruskavallerie", 1);
		}
		initDone = true;
	}

	@Override
	public void refreshen() {
		// Work-around, since the kategory information is only available 
		// *after* the first call of refreshen()
		if(!initDone && getKategorie() != 0) {
			checkKategorie();
		}

		rkBanner.setAktiv(oeS.isSelected());

		// Only if unit is selected as core
		if(getKategorie() == 3) {
			if(BuildaHQ.getCountFromInformationVector("EMSauruskavallerie") > 1) {
				setFehlermeldung(BuildaHQ.translate("0-1 Auswahl"));
			} else {
				setFehlermeldung("");
			}
		}	
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		// Only if unit is selected as core
		if(getKategorie() == 3) {
			BuildaHQ.addToInformationVector("EMSauruskavallerie", -1);
		}
	}
}
