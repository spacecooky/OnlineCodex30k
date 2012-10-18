package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ZWHammertraeger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkStandarte;
	
	public ZWHammertraeger() {
		name = BuildaHQ.translate("Hammerträger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Hammerträger"), 5, 100, 12);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWHammertraeger.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

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

		seperator();

	}

	@Override
	public void refreshen() {
		rkStandarte.setAktiv(oeS.isSelected());
		oe1.setPreis(squad.getModelle() * 1);	
	}
}
