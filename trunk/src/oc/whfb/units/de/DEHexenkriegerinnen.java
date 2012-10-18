package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DEHexenkriegerinnen extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	RuestkammerStarter rkGifts;
	boolean set = false;

	public DEHexenkriegerinnen() {
		name = BuildaHQ.translate("Hexenkriegerinnen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Hexenkriegerinnen"), 5, 100, 10);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEHexenkriegerinnen.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		rkGifts = new RuestkammerStarter(ID, randAbstand, cnt, "DEGiftsOfKhaine", "");
		rkGifts.initKammer(true, false, false);
		rkGifts.setButtonText(BuildaHQ.translate("Geschenke des Khaine"));
		add(rkGifts);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DEBanner", "");
		rkBanner.initKammer(true, false, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkGifts.setAktiv(oeC.isSelected());
		rkBanner.setAktiv(oeS.isSelected());	
	}
}
