package oc.whfb.units.he;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class HEBogenschuetzen extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	boolean ersteUnterGleichen = false;
	
	public HEBogenschuetzen() {
		name = BuildaHQ.translate("Bogenschützen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bogenschützen"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/HEBogenschuetzen.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Leichte Rüstung"), 1));

		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "HEBanner", "");
		rkBanner.initKammer(true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);

		// Unique entry: "Erste unter Gleichen"
		boolean eugGlobal = ( BuildaHQ.getCountFromInformationVector("HE_EUG") > 0 ? true : false );
		if(eugGlobal && !ersteUnterGleichen) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(true && oeS.isSelected());

		if(rkBanner.isSelected()) {
			ersteUnterGleichen = true;
			BuildaHQ.addToInformationVector("HE_EUG", 1);
		} else {
			if(ersteUnterGleichen) {
				ersteUnterGleichen = false;
				BuildaHQ.setInformationVectorValue("HE_EUG", 0);
				BuildaHQ.refreshEntries(3);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(ersteUnterGleichen) {
			BuildaHQ.setInformationVectorValue("HE_EUG", 0);
		}
		
		super.deleteYourself();
	}

}
