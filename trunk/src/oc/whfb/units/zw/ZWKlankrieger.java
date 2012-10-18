package oc.whfb.units.zw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ZWKlankrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade Grenzläufer;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	boolean GrenzläuferSelected = false;
	boolean set = false;

	public ZWKlankrieger() {
		name = BuildaHQ.translate("Klankrieger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Klankrieger"), 10, 100, 8);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/ZWKlankrieger.jpg"));

		seperator();

		add(Grenzläufer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Grenzläufern"), 1));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Zweihandwaffen"), 2));
		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfäxte"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		BuildaHQ.addToInformationVector("ZWKlankrieger" , 1);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 2);
		oe3.setPreis(squad.getModelle() * 1);
		Grenzläufer.setPreis(squad.getModelle() * 1);

		oe3.setAktiv(Grenzläufer.isSelected() && Grenzläufer.isAktiv() && oe2.isSelected());

		// Unique entry: Grenzläufer
		boolean GrenzläuferGlobal = (BuildaHQ.getCountFromInformationVector("ZWGrenzläufer") > 0 ? true : false );
		if(GrenzläuferGlobal && !GrenzläuferSelected) Grenzläufer.setAktiv(false);
		else Grenzläufer.setAktiv(oe2.isSelected());

		if(Grenzläufer.isSelected()) {
			GrenzläuferSelected = true;
			BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 1);
			if ( !set ) BuildaHQ.addToInformationVector("ZWKlankrieger" , -1);
			set = true;
		} else {
			if(GrenzläuferSelected) {
				GrenzläuferSelected = false;
				BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 0);
				BuildaHQ.refreshEntries(3);
				BuildaHQ.addToInformationVector("ZWKlankrieger" , 1);
				set = false;
			}
		}
	}
	
	public void deleteYourself() {
		if(GrenzläuferSelected) {
			BuildaHQ.setInformationVectorValue("ZWGrenzläufer", 0);
		} else {
            BuildaHQ.addToInformationVector("ZWKlankrieger" , -1);
        }
		super.deleteYourself();
	}

}
