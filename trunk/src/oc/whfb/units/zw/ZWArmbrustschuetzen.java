package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ZWArmbrustschuetzen extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade Grenzl�ufer;
	boolean Grenzl�uferSelected = false;

	public ZWArmbrustschuetzen() {
		name = BuildaHQ.translate("Armbrustsch�tzen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Armbrustsch�tzen"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWArmbrustschuetzen.jpg"));

		seperator();

		add(Grenzl�ufer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Grenzl�ufern"), 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartentr�ger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 2);

		Grenzl�ufer.setPreis(squad.getModelle() * 1);
		Grenzl�ufer.setAktiv(oe2.isSelected());

		// Unique entry: Grenzl�ufer
		boolean Grenzl�uferGlobal = (BuildaHQ.getCountFromInformationVector("ZWGrenzl�ufer") > 0 ? true : false );
		if(Grenzl�uferGlobal && !Grenzl�uferSelected) Grenzl�ufer.setAktiv(false);
		else Grenzl�ufer.setAktiv(oe2.isSelected());

		if(Grenzl�ufer.isSelected()) {
			Grenzl�uferSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 1);
		} else {
			if(Grenzl�uferSelected) {
				Grenzl�uferSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 0);
				BuildaHQ.refreshEntries(3);
			}
		}
	}

	public void deleteYourself() {
		if(Grenzl�uferSelected) {
			BuildaHQ.setInformationVectorValue("ZWGrenzl�ufer", 0);
		}
		super.deleteYourself();
	}

}
