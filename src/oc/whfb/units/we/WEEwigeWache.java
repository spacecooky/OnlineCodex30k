package oc.whfb.units.we;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class WEEwigeWache extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	boolean EGMagicStandardSelected = false;

	public WEEwigeWache() {
		name = BuildaHQ.translate("Ewige Wache");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ewige Wachen"), 10, 100, 12);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/WEEwigeWache.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "WEBanner", "");
		rkBanner.initKammer(false, true);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		// Unique entry: EGMagicStandard
		boolean EGMagicStandardGlobal = (BuildaHQ.getCountFromInformationVector("WEEGMagicStandard") > 0 ? true : false );
		if(EGMagicStandardGlobal && !EGMagicStandardSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(oeS.isSelected());

		if(rkBanner.isSelected()) {
			EGMagicStandardSelected = true;
			BuildaHQ.setInformationVectorValue("WEEGMagicStandard", 1);
		} else {
			if(EGMagicStandardSelected) {
				EGMagicStandardSelected = false;
				BuildaHQ.setInformationVectorValue("WEEGMagicStandard", 0);
				BuildaHQ.refreshEntries(3);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(EGMagicStandardSelected) BuildaHQ.setInformationVectorValue("WEEGMagicStandard", 0);
	}
}
