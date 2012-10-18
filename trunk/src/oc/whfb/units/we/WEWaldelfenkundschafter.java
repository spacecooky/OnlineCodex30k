package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class WEWaldelfenkundschafter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	boolean GGMagicStandardSelected = false;
	
	public WEWaldelfenkundschafter() {
		name = BuildaHQ.translate("Waldelfenkundschafter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Waldelfenkundschafter"), 5, 10, 17);
		squad.setGrundkosten(0);
		add(squad);

		BuildaHQ.addToInformationVector("WEWaldelfenkundschafter", 1);

		add(ico = new oc.Picture("oc/images/WEWaldelfenkundschafter.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 6));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "WEBanner", "");
		rkBanner.initKammer(false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		boolean Fehler = BuildaHQ.getCountFromInformationVector("WEWaldelfenkundschafter") > BuildaHQ.getCountFromInformationVector("WEWaldelfenkrieger");
		if(Fehler) setFehlermeldung(BuildaHQ.translate("zu viele Kundschafter"));
		else setFehlermeldung("");

		// Unique entry: GGMagicStandard
		boolean GGMagicStandardGlobal = (BuildaHQ.getCountFromInformationVector("WEGGMagicStandard") > 0 ? true : false );
		if(GGMagicStandardGlobal && !GGMagicStandardSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(oeS.isSelected());

		if(rkBanner.isSelected()) {
			GGMagicStandardSelected = true;
			BuildaHQ.setInformationVectorValue("WEGGMagicStandard", 1);
		} else {
			if(GGMagicStandardSelected) {
				GGMagicStandardSelected = false;
				BuildaHQ.setInformationVectorValue("WEGGMagicStandard", 0);
				BuildaHQ.refreshEntries(3);
			}
		}
	}

	public void deleteYourself() {
		BuildaHQ.addToInformationVector("WEWaldelfenkundschafter", -1);
	}
}
