package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ZWEisenbrecher extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkStandarte;
	
	public ZWEisenbrecher() {
		name = BuildaHQ.translate("Eisenbrecher");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Eisenbrecher"), 5, 100, 13);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWEisenbrecher.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));

		seperator();

		rkStandarte = new RuestkammerStarter(ID, randAbstand, cnt, "ZWStandarte", "");
		rkStandarte.initKammer(false);
		rkStandarte.setButtonText(BuildaHQ.translate("Runenstandarte"));
		rkStandarte.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkStandarte);

		complete();

	}

	@Override
	public void refreshen() {
		rkStandarte.setAktiv(oeS.isSelected());	
	}
}
