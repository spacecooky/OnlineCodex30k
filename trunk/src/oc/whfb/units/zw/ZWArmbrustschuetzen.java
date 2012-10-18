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
	OptionsEinzelUpgrade Grenzläufer;
	boolean GrenzläuferSelected = false;

	public ZWArmbrustschuetzen() {
		name = BuildaHQ.translate("Armbrustschützen");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Armbrustschützen"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWArmbrustschuetzen.jpg"));

		seperator();

		add(Grenzläufer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Grenzläufern"), 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 2);

		Grenzläufer.setPreis(squad.getModelle() * 1);
		Grenzläufer.setAktiv(oe2.isSelected());

		// Unique entry: Grenzläufer
		boolean GrenzläuferGlobal = (BuildaHQ.getCountFromInformationVector("ZWGrenzläufer") > 0 ? true : false );
		if(GrenzläuferGlobal && !GrenzläuferSelected) Grenzläufer.setAktiv(false);
		else Grenzläufer.setAktiv(oe2.isSelected());

		if(Grenzläufer.isSelected()) {
			GrenzläuferSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 1);
		} else {
			if(GrenzläuferSelected) {
				GrenzläuferSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 0);
				BuildaHQ.refreshEntries(3);
			}
		}
	}

	public void deleteYourself() {
		if(GrenzläuferSelected) {
			BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 0);
		}
		super.deleteYourself();
	}

}
